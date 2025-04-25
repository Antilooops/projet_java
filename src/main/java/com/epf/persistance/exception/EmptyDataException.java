package com.epf.persistance.exception;

public class EmptyDataException extends RuntimeException {
    public EmptyDataException() {
        super(" | No data has been found in database");
    }

    public EmptyDataException(String message) {
        super(message);
    }
}
