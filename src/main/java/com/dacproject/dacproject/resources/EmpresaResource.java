package com.dacproject.dacproject.resources;

import com.dacproject.dacproject.dtos.EmpresaDTO;
import com.dacproject.dacproject.services.EmpresaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {

    private final EmpresaService empresaService;

    public EmpresaResource(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<Page<EmpresaDTO>> findAll(Pageable pageable) {
        Page < EmpresaDTO > list = empresaService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity < EmpresaDTO > findById(@PathVariable Long id) {
        EmpresaDTO dto = empresaService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity < EmpresaDTO > insert(@RequestBody EmpresaDTO dto) {
        dto = empresaService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity < EmpresaDTO > update(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
        dto = empresaService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity < Void > delete (@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}