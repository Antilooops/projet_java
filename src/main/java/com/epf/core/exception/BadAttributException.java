package com.epf.core.exception;

public class BadAttributException extends RuntimeException {
    public BadAttributException() {
        super(" | DTO attribut not set correctly");
    }

    public BadAttributException(String message) {
        super(message);
    }

    public BadAttributException(String message, Throwable t) {
        super(message, t);
    }
}
