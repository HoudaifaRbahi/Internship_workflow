package com.app.library.exceptions;

import lombok.Getter;

import java.util.Set;

public class InvalidEntityException extends RuntimeException{
   @Getter
    private ErrorCodes errorCodes;
    @Getter
    private Set<String>errors;
    public InvalidEntityException(String message){
        super(message);
    }
    public InvalidEntityException(String message,Throwable cause){
        super(message,cause);
    }
    public InvalidEntityException(String message,ErrorCodes errorCodes){
        super(message);
        this.errorCodes=errorCodes;
    }
    public InvalidEntityException(String message, ErrorCodes errorCodes, Set<String> errors){
        super(message);
        this.errorCodes=errorCodes;
        this.errors=errors;
    }
}
