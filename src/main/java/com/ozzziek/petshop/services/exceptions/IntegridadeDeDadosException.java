package com.ozzziek.petshop.services.exceptions;

public class IntegridadeDeDadosException extends RuntimeException{
    public IntegridadeDeDadosException(String msg) {
        super(msg);
    }

    public IntegridadeDeDadosException(String msg, Throwable causa) {
        super(msg, causa);
    }

}
