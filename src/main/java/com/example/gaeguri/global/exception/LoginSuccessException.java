package com.example.gaeguri.global.exception;

public class LoginSuccessException extends RuntimeException{
    public LoginSuccessException() {
    }

    public LoginSuccessException(String message) {
        super(message);
    }

    public LoginSuccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
