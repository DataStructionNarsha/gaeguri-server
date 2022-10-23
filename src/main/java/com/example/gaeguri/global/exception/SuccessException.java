package com.example.gaeguri.global.exception;

public class SuccessException extends RuntimeException{
    public SuccessException() {
    }

    public SuccessException(String message) {
        super(message);
    }

    public SuccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
