package com.aquarius.aquariusapi.service.exceptions;

public class EnderecoImcompletoException extends Throwable {

    public EnderecoImcompletoException(String mensagem) {
        super(mensagem);
    }

    public EnderecoImcompletoException(String mensagem, Throwable cause){
        super(mensagem, cause);
    }
}
