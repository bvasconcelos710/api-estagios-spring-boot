package com.dacproject.dacproject.resources;

import com.dacproject.dacproject.dtos.OrientadorDTO;
import com.dacproject.dacproject.services.OrientadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orientadores")
public class OrientadorResource {

    private final OrientadorService orientadorService;

    public OrientadorResource(OrientadorService orientadorService) {
        this.orientadorService = orientadorService;
    }

    @GetMapping
    public ResponseEntity<Page<OrientadorDTO>> findAll(Pageable pageable) {
        Page < OrientadorDTO > list = orientadorService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity < OrientadorDTO > findById(@PathVariable Long id) {
        OrientadorDTO dto = orientadorService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity < OrientadorDTO > insert(@RequestBody OrientadorDTO dto) {
        dto = orientadorService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity < OrientadorDTO > update(@PathVariable Long id, @RequestBody OrientadorDTO dto) {
        dto = orientadorService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity < Void > delete (@PathVariable Long id) {
        orientadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}