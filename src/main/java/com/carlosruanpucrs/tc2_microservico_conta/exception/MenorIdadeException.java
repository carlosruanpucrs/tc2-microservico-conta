package com.carlosruanpucrs.tc2_microservico_conta.exception;

public class MenorIdadeException extends RuntimeException {

    private static final String MSG = "Idade minima para abrir conta é 18 anos";

    public MenorIdadeException() {
        super(MSG);
    }
}
