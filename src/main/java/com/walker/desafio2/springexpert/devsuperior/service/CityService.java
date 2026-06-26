package com.walker.desafio2.springexpert.devsuperior.service;

import com.walker.desafio2.springexpert.devsuperior.exception.DatabaseException;
import com.walker.desafio2.springexpert.devsuperior.exception.ResourceNotFoundException;
import com.walker.desafio2.springexpert.devsuperior.model.City;
import com.walker.desafio2.springexpert.devsuperior.model.dto.CityDTO;
import com.walker.desafio2.springexpert.devsuperior.repository.CityRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CityService {
    //dependency injection
    private final CityRepository cityRepository;
    //constructors
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    //methods
    @Transactional(readOnly = true)
    public List<CityDTO> findAllByOrderByName() {
        return cityRepository.findAllByOrderByNameAsc()
                .stream()
                .map(CityDTO::new)
                .toList();
    }
    @Transactional
    public CityDTO insert(CityDTO cityDTO) {
        City city = new City();
        copyDTOToEntity(cityDTO, city);
        city = cityRepository.save(city);
        return new CityDTO(city);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id not found: " + id); //id não existe - 404
        }
        try {
            cityRepository.deleteById(id);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DatabaseException("Integrity violation - Category has dependencies");
        }
    }

    private void copyDTOToEntity(CityDTO dto, City entity) {
        entity.setName(dto.getName());
    }
}
