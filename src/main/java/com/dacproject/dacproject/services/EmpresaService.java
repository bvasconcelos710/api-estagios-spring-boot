/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.services;

import com.dacproject.dacproject.dtos.EmpresaDTO;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.repositories.EmpresaRepository;
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
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional(readOnly = true)
    public Page<EmpresaDTO> findAllPaged(Pageable pageable) {
        Page<Empresa> list = repository.findAll(pageable);
        return list.map(x -> new EmpresaDTO(x));
    }

    @Transactional(readOnly = true)
    public EmpresaDTO findById(Long id) {
        Optional<Empresa> obj = repository.findById(id);
        Empresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new EmpresaDTO(entity);
    }

    @Transactional
    public EmpresaDTO insert(EmpresaDTO dto) {
        Empresa entity = new Empresa();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EmpresaDTO(entity);
    }

    @Transactional
    public EmpresaDTO update(Long id, EmpresaDTO dto) {
        try {
            Empresa entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EmpresaDTO(entity);
        } catch (EntityNotFoundException e) {
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

    private void copyDtoToEntity(EmpresaDTO dto, Empresa entity) {

        entity.setNome(dto.getNome());
        entity.setCnpj(dto.getCnpj());

    }
}
