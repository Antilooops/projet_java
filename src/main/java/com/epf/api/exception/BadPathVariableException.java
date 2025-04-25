package com.epf.api.exception;

public class BadPathVariableException extends RuntimeException {

    public BadPathVariableException() {
        super("URL path variable has not been set correctly");
    }

    public BadPathVariableException(String message) {
        super(message);
    }

    public BadPathVariableException(String message, Throwable t) {
        super(message, t);
    }
}
