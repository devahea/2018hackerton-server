package com.ahea.nurikabe.common.error;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}