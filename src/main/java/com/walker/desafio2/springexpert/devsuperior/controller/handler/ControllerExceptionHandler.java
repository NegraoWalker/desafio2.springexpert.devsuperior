package com.walker.desafio2.springexpert.devsuperior.controller.handler;

import com.walker.desafio2.springexpert.devsuperior.exception.DatabaseException;
import com.walker.desafio2.springexpert.devsuperior.exception.ResourceNotFoundException;
import com.walker.desafio2.springexpert.devsuperior.model.dto.StandardErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorDTO> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErrorDTO standardErrorDTO = new StandardErrorDTO();
        standardErrorDTO.setTimestamp(Instant.now());
        standardErrorDTO.setStatus(status.value());
        standardErrorDTO.setError("Resource not found!");
        standardErrorDTO.setMessage(resourceNotFoundException.getMessage());
        standardErrorDTO.setPath(httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standardErrorDTO);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardErrorDTO> databaseException(DatabaseException databaseException, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardErrorDTO standardErrorDTO = new StandardErrorDTO();
        standardErrorDTO.setTimestamp(Instant.now());
        standardErrorDTO.setStatus(status.value());
        standardErrorDTO.setError("Data integrity violation!");
        standardErrorDTO.setMessage(databaseException.getMessage());
        standardErrorDTO.setPath(httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standardErrorDTO);
    }

}
