package com.example.gaeguri.global.exception;

public class AuthenticationEntryPointException extends RuntimeException {
    public AuthenticationEntryPointException() {
    }

    public AuthenticationEntryPointException(String message) {
        super(message);
    }

    public AuthenticationEntryPointException(String message, Throwable cause) {
        super(message, cause);
    }
}
