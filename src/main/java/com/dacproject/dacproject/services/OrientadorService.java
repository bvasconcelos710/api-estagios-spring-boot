/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.services;

import com.dacproject.dacproject.dtos.OrientadorDTO;
import com.dacproject.dacproject.entities.Orientador;
import com.dacproject.dacproject.repositories.OrientadorRepository;
import com.dacproject.dacproject.services.execptions.DatabaseException;
import com.dacproject.dacproject.services.execptions.ResourceNotFoundException;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrientadorService {

    @Autowired
    private OrientadorRepository repository;

    @Transactional(readOnly = true)
    public Page<OrientadorDTO> findAllPaged(Pageable pageable) {
        Page<Orientador> list = repository.findAll(pageable);
        return list.map(x -> new OrientadorDTO(x));
    }

    @Transactional(readOnly = true)
    public OrientadorDTO findById(Long id) {
        Optional<Orientador> obj = repository.findById(id);
        Orientador entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new OrientadorDTO(entity);
    }

    @Transactional
	public OrientadorDTO insert(OrientadorDTO dto) {
		Orientador entity = new Orientador();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new OrientadorDTO(entity);
	}

	@Transactional
	public OrientadorDTO update(Long id, OrientadorDTO dto) {
		try {
			Orientador entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new OrientadorDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(OrientadorDTO dto, Orientador entity) {

		entity.setNome(dto.getNome());
		entity.setDisciplina(dto.getDisciplina());
}
}
