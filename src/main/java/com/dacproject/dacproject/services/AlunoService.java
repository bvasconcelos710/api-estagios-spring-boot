/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.services;

import com.dacproject.dacproject.dtos.AlunoDTO;
import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.repositories.AlunoRepository;
import com.dacproject.dacproject.services.execptions.DatabaseException;
import com.dacproject.dacproject.services.execptions.ResourceNotFoundException;
import java.io.Serializable;
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
public class AlunoService implements Serializable {

    @Autowired
    private AlunoRepository repository;

    @Transactional(readOnly = true)
    public Page<AlunoDTO> findAllPaged(Pageable pageable) {
        Page<Aluno> list = repository.findAll(pageable);
        return list.map(x -> new AlunoDTO(x));
    }

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        Optional<Aluno> obj = repository.findById(id);
        Aluno entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new AlunoDTO(entity);
    }

    @Transactional
    public AlunoDTO insert(AlunoDTO dto) {
        Aluno entity = new Aluno();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AlunoDTO(entity);
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        try {
			Aluno entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AlunoDTO(entity);
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

    private void copyDtoToEntity(AlunoDTO dto, Aluno entity) {

        entity.setNome(dto.getNome());
        entity.setMatricula(dto.getMatricula());
    }
}
