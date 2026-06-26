package com.walker.desafio2.springexpert.devsuperior.controller;

import com.walker.desafio2.springexpert.devsuperior.model.dto.EventDTO;
import com.walker.desafio2.springexpert.devsuperior.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    //dependency injection
    private final EventService eventService;
    //constructors
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    //methods
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        eventDTO = eventService.update(id, eventDTO);
        return ResponseEntity.ok().body(eventDTO);
    }
}
