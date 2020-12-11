package com.aquarius.aquariusapi.service.exceptions;

public class EstadoJaCadastradoException extends RuntimeException {

    public EstadoJaCadastradoException(String mensagem) {
        super(mensagem);
    }

    public EstadoJaCadastradoException(String menssagem, Throwable cause){
        super(menssagem, cause);
    }
}
