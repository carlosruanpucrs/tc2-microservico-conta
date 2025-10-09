package com.carlosruanpucrs.tc2_microservico_conta.exception;

public class DocumentoClienteExisteException extends RuntimeException {

    private static final String MSG = "DOCUMENTO CLIENTE %S JA EXISTE";

    public DocumentoClienteExisteException(String documento) {
        super(String.format(MSG, documento));
    }
}
