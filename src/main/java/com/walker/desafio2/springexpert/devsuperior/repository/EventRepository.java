package com.walker.desafio2.springexpert.devsuperior.repository;

import com.walker.desafio2.springexpert.devsuperior.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
