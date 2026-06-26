package com.walker.desafio2.springexpert.devsuperior.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;
    private String url;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    //constructors
    public Event() {
    }
    public Event(Long id, String name, LocalDate date, String url) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.url = url;
    }
    public Event(Long id, String name, LocalDate date, String url, City city) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.url = url;
        this.city = city;
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
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

/*
    1. Mapeamento JPA:
    - Na implementação do relacionamento Nx1 entre entidades - sempre o dono do relacionamento (dependente) é o lado N:
        - O dono fica com:
            @ManyToOne
            @JoinColumn(name = "nome_coluna_fk_no_banco")
        - O lado espelho fica com:
            @OneToMany(mappedBy = "nome-do-atributo-java-na-entidade-dona")
            variável do tipo List
    - Na implementação do relacionamento 1x1 entre entidades - você escolhe o dono do relacionamento (dependente):
        - O dono fica com:
            @OneToOne
            @JoinColumn(name = "nome_coluna_fk_no_banco")
        - O lado espelho fica com:
            @OneToOne(mappedBy = "nome-do-atributo-java-na-entidade-dona")
    - Na implementação do relacionamento NxN entre entidades - você escolhe o dono do relacionamento (dependente):
        - O dono fica com:
            @ManyToMany
            @JoinTable(
                name = "nome_tabela_associativa",
                joinColumns = @JoinColumn(name = "nome_coluna_fk_dona"),
                inverseJoinColumns = @JoinColumn(name = "nome_coluna_fk_espelho")
            )
            variável do tipo List
        - O lado espelho fica com:
            @ManyToMany(mappedBy = "nome-do-atributo-java-na-entidade-dona")
            variável do tipo List
*/