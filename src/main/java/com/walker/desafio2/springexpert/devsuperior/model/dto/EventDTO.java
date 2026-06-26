package com.walker.desafio2.springexpert.devsuperior.model.dto;

import com.walker.desafio2.springexpert.devsuperior.model.Event;

import java.time.LocalDate;

public class EventDTO {
    //fields
    private Long id;
    private String name;
    private LocalDate date;
    private String url;
    private Long cityId;
    //constructors
    public EventDTO() {
    }
    public EventDTO(Long id, String name, LocalDate date, String url) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.url = url;
    }
    public EventDTO(Long id, String name, LocalDate date, String url, Long cityId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.url = url;
        this.cityId = cityId;
    }
    //converte de entidade para dto
    public EventDTO (Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.url = event.getUrl();
        this.cityId = event.getCity().getId();
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
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
