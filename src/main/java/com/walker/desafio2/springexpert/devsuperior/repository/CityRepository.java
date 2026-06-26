package com.walker.desafio2.springexpert.devsuperior.repository;

import com.walker.desafio2.springexpert.devsuperior.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    public List<City> findAllByOrderByNameAsc();
}
