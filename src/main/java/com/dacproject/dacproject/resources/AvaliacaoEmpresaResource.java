package com.dacproject.dacproject.resources;

import com.dacproject.dacproject.dtos.AvaliacaoEmpresaDTO;
import com.dacproject.dacproject.services.AvaliacaoEmpresaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/avaliacoes-empresa")
public class AvaliacaoEmpresaResource {

    private final AvaliacaoEmpresaService avaliacaoEmpresaService;

    public AvaliacaoEmpresaResource(AvaliacaoEmpresaService avaliacaoEmpresaService) {
        this.avaliacaoEmpresaService = avaliacaoEmpresaService;
    }

    @GetMapping
    public ResponseEntity<Page<AvaliacaoEmpresaDTO>> findAll(Pageable pageable) {
        Page<AvaliacaoEmpresaDTO> list = avaliacaoEmpresaService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoEmpresaDTO> findById(@PathVariable Long id) {
        AvaliacaoEmpresaDTO dto = avaliacaoEmpresaService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoEmpresaDTO> insert(@RequestBody AvaliacaoEmpresaDTO dto) {
        dto = avaliacaoEmpresaService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoEmpresaDTO> update(@PathVariable Long id, @RequestBody AvaliacaoEmpresaDTO dto) {
        dto = avaliacaoEmpresaService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        avaliacaoEmpresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
