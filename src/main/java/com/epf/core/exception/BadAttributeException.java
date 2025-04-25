package com.epf.core.exception;

public class BadAttributeException extends RuntimeException {
    public BadAttributeException() {
        super(" | DTO attribut not set correctly");
    }

    public BadAttributeException(String message) {
        super(message);
    }

    public BadAttributeException(String message, Throwable t) {
        super(message, t);
    }
}
