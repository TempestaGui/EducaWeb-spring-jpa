package org.educandoweb.educaweb.controller.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.educandoweb.educaweb.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //interceptar excecoes
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //faz com que o metodo trate qualuqer excecao desse tipo
    public ResponseEntity<StandardError> resourceNoFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
