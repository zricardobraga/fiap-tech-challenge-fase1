package br.com.restaurant_manager.restaurant_manager.infra.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {super(message);};
}
