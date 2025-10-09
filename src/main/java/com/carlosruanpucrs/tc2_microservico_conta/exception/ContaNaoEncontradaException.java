package com.carlosruanpucrs.tc2_microservico_conta.exception;

public class ContaNaoEncontradaException extends RuntimeException {

    private static final String MSG = "CONTA %S NAO ENCONTRADA";

    public ContaNaoEncontradaException(Integer numeroConta) {
        super(String.format(MSG, numeroConta));
    }
}