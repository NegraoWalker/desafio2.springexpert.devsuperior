package com.walker.desafio2.springexpert.devsuperior.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cities")
public class City {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Event> events = new ArrayList<>();
    //constructors
    public City() {
    }
    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public City(Long id, String name, List<Event> events) {
        this.id = id;
        this.name = name;
        this.events = events;
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
    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
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
