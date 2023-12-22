/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.services;

import com.dacproject.dacproject.dtos.EstagioDTO;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.repositories.EstagioRepository;
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
public class EstagioService {

    @Autowired
    private EstagioRepository repository;

    @Transactional(readOnly = true)
    public Page<EstagioDTO> findAllPaged(Pageable pageable) {
        Page<Estagio> list = repository.findAll(pageable);
        return list.map(x -> new EstagioDTO(x));
    }

    @Transactional(readOnly = true)
    public EstagioDTO findById(Long id) {
        Optional<Estagio> obj = repository.findById(id);
        Estagio entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new EstagioDTO(entity);
    }

    @Transactional
    public EstagioDTO insert(EstagioDTO dto) {
        Estagio entity = new Estagio();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EstagioDTO(entity);
    }

    @Transactional
    public EstagioDTO update(Long id, EstagioDTO dto) {
        try {
            Estagio entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EstagioDTO(entity);
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

    private void copyDtoToEntity(EstagioDTO dto, Estagio entity) {

        entity.setInicio(dto.getInicio());
        entity.setFim(dto.getFim());
        entity.setCargaHoraria(dto.getCargaHoraria());
        entity.setStatus(dto.getStatus());
        entity.setTotalHoras(dto.getTotalHoras());
        entity.setAluno(dto.getAluno());
        entity.setEmpresa(dto.getEmpresa());
        entity.setOrientador(dto.getOrientador());

    }
}
