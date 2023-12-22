package com.dacproject.dacproject.resources;

import com.dacproject.dacproject.dtos.EstagioDTO;
import com.dacproject.dacproject.services.EstagioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/estagios")
public class EstagioResource {

    private final EstagioService estagioService;

    public EstagioResource(EstagioService estagioService) {
        this.estagioService = estagioService;
    }

    @GetMapping
    public ResponseEntity<Page<EstagioDTO>> findAll(Pageable pageable) {
        Page < EstagioDTO > list = estagioService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity < EstagioDTO > findById(@PathVariable Long id) {
        EstagioDTO dto = estagioService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity < EstagioDTO > insert(@RequestBody EstagioDTO dto) {
        dto = estagioService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity < EstagioDTO > update(@PathVariable Long id, @RequestBody EstagioDTO dto) {
        dto = estagioService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity < Void > delete (@PathVariable Long id) {
        estagioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}