/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.services;

import com.dacproject.dacproject.dtos.AvaliacaoOrientadorDTO;
import com.dacproject.dacproject.entities.AvaliacaoOrientador;
import com.dacproject.dacproject.repositories.AvaliacaoOrientadorRepository;
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
public class AvaliacaoOrientadorService {
    
    @Autowired
    private AvaliacaoOrientadorRepository repository;
    
    @Transactional(readOnly = true)
    public Page<AvaliacaoOrientadorDTO> findAllPaged(Pageable pageable) {
        Page<AvaliacaoOrientador> list = repository.findAll(pageable);
        return list.map(x -> new AvaliacaoOrientadorDTO(x));
    }

    @Transactional(readOnly = true)
    public AvaliacaoOrientadorDTO findById(Long id) {
        Optional<AvaliacaoOrientador> obj = repository.findById(id);
        AvaliacaoOrientador entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new AvaliacaoOrientadorDTO(entity);
    }
    
    @Transactional
    public AvaliacaoOrientadorDTO insert(AvaliacaoOrientadorDTO dto) {
        AvaliacaoOrientador entity = new AvaliacaoOrientador();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AvaliacaoOrientadorDTO(entity);
    }

    @Transactional
    public AvaliacaoOrientadorDTO update(Long id, AvaliacaoOrientadorDTO dto) {
        try {
            AvaliacaoOrientador entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AvaliacaoOrientadorDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(AvaliacaoOrientadorDTO dto, AvaliacaoOrientador entity) {

        entity.setAluno(dto.getAluno());
        entity.setOrientador(dto.getOrientador());
        entity.setAssiduidade(dto.getAssiduidade());
        entity.setDisciplina(dto.getDisciplina());
        entity.setIniciativa(dto.getIniciativa());
        entity.setResponsabilidade(dto.getResponsabilidade());
        entity.setSociabilidade(dto.getSociabilidade());
    }
}
