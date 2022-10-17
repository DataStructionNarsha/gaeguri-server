package com.example.gaeguri.global.exception;

public class MemberEmailAlreadyExistsException extends RuntimeException{
    public MemberEmailAlreadyExistsException(){

    }
    public MemberEmailAlreadyExistsException(String message){
        super(message);
    }
    public MemberEmailAlreadyExistsException(String message, Throwable cause){
        super(message, cause);
    }

}
