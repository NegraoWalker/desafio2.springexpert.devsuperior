package com.walker.desafio2.springexpert.devsuperior.service;

import com.walker.desafio2.springexpert.devsuperior.exception.ResourceNotFoundException;
import com.walker.desafio2.springexpert.devsuperior.model.City;
import com.walker.desafio2.springexpert.devsuperior.model.Event;
import com.walker.desafio2.springexpert.devsuperior.model.dto.EventDTO;
import com.walker.desafio2.springexpert.devsuperior.repository.CityRepository;
import com.walker.desafio2.springexpert.devsuperior.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {
    //dependency injection
    private final EventRepository eventRepository;
    private final CityRepository cityRepository;
    //constructors
    public EventService(EventRepository eventRepository, CityRepository cityRepository) {
        this.eventRepository = eventRepository;
        this.cityRepository = cityRepository;
    }
    //methods
    @Transactional
    public EventDTO update(Long id, EventDTO eventDTO) {
        try {
            Event event = eventRepository.getReferenceById(id);
            copyDTOToEntity(eventDTO, event);
            event = eventRepository.save(event);
            return new EventDTO(event);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ResourceNotFoundException("Id not found: " + id); //id não existe - 404
        }
    }

    private void copyDTOToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        City city = cityRepository.getReferenceById(dto.getCityId());
        entity.setCity(city);
    }
}
