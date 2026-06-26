package com.walker.desafio2.springexpert.devsuperior.controller;

import com.walker.desafio2.springexpert.devsuperior.model.dto.CityDTO;
import com.walker.desafio2.springexpert.devsuperior.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    //dependency injection
    private final CityService cityService;
    //constructors
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    //methods
    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> list = cityService.findAllByOrderByName();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO cityDTO) {
        cityDTO = cityService.insert(cityDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cityDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(cityDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
