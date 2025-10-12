package com.carlosruanpucrs.tc2_microservico_conta.api.response;

import com.carlosruanpucrs.tc2_microservico_conta.enums.SituacaoContaEnum;
import com.carlosruanpucrs.tc2_microservico_conta.enums.TipoContaEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContaResponse {

    Integer numeroConta;
    Integer numeroBeneficio;
    String documentoCliente;
    String nomeCliente;
    SituacaoContaEnum situacao;
    LocalDate dataCriacao;
    TipoContaEnum tipoConta;
}
