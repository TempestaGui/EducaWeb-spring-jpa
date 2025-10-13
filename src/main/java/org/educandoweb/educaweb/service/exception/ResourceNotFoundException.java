package org.educandoweb.educaweb.service.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Resource not found with id "+ id);
    }
}
