package com.carlosruanpucrs.tc2_microservico_conta.api.response;

import com.carlosruanpucrs.tc2_microservico_conta.enums.SituacaoContaEnum;
import com.carlosruanpucrs.tc2_microservico_conta.enums.TipoContaEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaResponse {

    Integer numeroConta;
    String documentoCliente;
    String nomeCliente;
    SituacaoContaEnum situacao;
    LocalDate dataCriacao;
    BigDecimal saldo;
    BigDecimal saldoBloqueado;
    TipoContaEnum tipoConta;
    Integer numeroBeneficio;
}
