package com.carlosruanpucrs.tc2_microservico_conta.exception;

public class CepInvalidoException extends RuntimeException {

    private static final String MSG = "CEP %S INVALIDO";

    public CepInvalidoException(String cep) {
        super(String.format(MSG, cep));
    }

}

