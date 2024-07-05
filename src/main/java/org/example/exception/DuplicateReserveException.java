package org.example.exception;

public class DuplicateReserveException extends RuntimeException {
    public DuplicateReserveException(String message) {
        super(message);
    }
}
