package com.ozzziek.petshop.services.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException{
    public ObjetoNaoEncontradoException(String msg) {
        super(msg);
    }

    public ObjetoNaoEncontradoException(String msg, Throwable causa) {
        super(msg, causa);
    }

}
