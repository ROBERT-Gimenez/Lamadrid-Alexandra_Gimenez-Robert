package com.backend.Clinica_Odontologica.exeptions;

public class ResourceNotFoundException  extends Exception{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}