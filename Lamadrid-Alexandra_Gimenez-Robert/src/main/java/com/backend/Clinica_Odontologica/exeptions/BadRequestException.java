package com.backend.Clinica_Odontologica.exeptions;

public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}