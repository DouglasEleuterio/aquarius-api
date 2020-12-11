package com.aquarius.aquariusapi.service.exceptions;

public class EstadoSemNomeException extends RuntimeException  {
    private static final long serialVersionUID = 1L;

    public EstadoSemNomeException(String menssagem){
        super(menssagem);
    }

    public EstadoSemNomeException(String menssagem, Throwable cause){
        super(menssagem, cause);
    }
}
