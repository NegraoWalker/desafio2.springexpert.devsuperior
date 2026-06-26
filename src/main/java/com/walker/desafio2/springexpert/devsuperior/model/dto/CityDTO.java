package com.walker.desafio2.springexpert.devsuperior.model.dto;


import com.walker.desafio2.springexpert.devsuperior.model.City;

public class CityDTO {
    //fields
    private Long id;
    private String name;
    //constructors
    public CityDTO() {
    }
    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    //converte de entidade para dto
    public CityDTO (City city) {
        this.id = city.getId();
        this.name = city.getName();
    }
    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
