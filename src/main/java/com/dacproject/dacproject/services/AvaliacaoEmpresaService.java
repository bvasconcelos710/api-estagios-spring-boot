/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.services;

import com.dacproject.dacproject.dtos.AvaliacaoEmpresaDTO;
import com.dacproject.dacproject.entities.AvaliacaoEmpresa;
import com.dacproject.dacproject.repositories.AvaliacaoEmpresaRepository;
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
public class AvaliacaoEmpresaService {

    @Autowired
    private AvaliacaoEmpresaRepository repository;

    @Transactional(readOnly = true)
    public Page<AvaliacaoEmpresaDTO> findAllPaged(Pageable pageable) {
        Page<AvaliacaoEmpresa> list = repository.findAll(pageable);
        return list.map(x -> new AvaliacaoEmpresaDTO(x));
    }

    @Transactional(readOnly = true)
    public AvaliacaoEmpresaDTO findById(Long id) {
        Optional<AvaliacaoEmpresa> obj = repository.findById(id);
        AvaliacaoEmpresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new AvaliacaoEmpresaDTO(entity);
    }

    @Transactional
    public AvaliacaoEmpresaDTO insert(AvaliacaoEmpresaDTO dto) {
        AvaliacaoEmpresa entity = new AvaliacaoEmpresa();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AvaliacaoEmpresaDTO(entity);
    }

    @Transactional
    public AvaliacaoEmpresaDTO update(Long id, AvaliacaoEmpresaDTO dto) {
        try {
            AvaliacaoEmpresa entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AvaliacaoEmpresaDTO(entity);
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

    private void copyDtoToEntity(AvaliacaoEmpresaDTO dto, AvaliacaoEmpresa entity) {

        entity.setAluno(dto.getAluno());
        entity.setEmpresa(dto.getEmpresa());
        entity.setAprendizagem(dto.getAprendizagem());
        entity.setConhecimento(dto.getConhecimento());
        entity.setDesempenho(dto.getDesempenho());
        entity.setCumprimentoTarefas(dto.getCumprimentoTarefas());
        entity.setRendimento(dto.getRendimento());

    }
}
