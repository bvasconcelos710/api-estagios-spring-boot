package com.dacproject.dacproject.resources;

import com.dacproject.dacproject.dtos.AvaliacaoOrientadorDTO;
import com.dacproject.dacproject.services.AvaliacaoOrientadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/avaliacoes-orientador")
public class AvaliacaoOrientadorResource {

    private final AvaliacaoOrientadorService avaliacaoOrientadorService;

    public AvaliacaoOrientadorResource(AvaliacaoOrientadorService avaliacaoOrientadorService) {
        this.avaliacaoOrientadorService = avaliacaoOrientadorService;
    }

    @GetMapping
    public ResponseEntity<Page<AvaliacaoOrientadorDTO>> findAll(Pageable pageable) {
        Page<AvaliacaoOrientadorDTO> list = avaliacaoOrientadorService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoOrientadorDTO> findById(@PathVariable Long id) {
        AvaliacaoOrientadorDTO dto = avaliacaoOrientadorService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoOrientadorDTO> insert(@RequestBody AvaliacaoOrientadorDTO dto) {
        dto = avaliacaoOrientadorService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoOrientadorDTO> update(@PathVariable Long id, @RequestBody AvaliacaoOrientadorDTO dto) {
        dto = avaliacaoOrientadorService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        avaliacaoOrientadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
