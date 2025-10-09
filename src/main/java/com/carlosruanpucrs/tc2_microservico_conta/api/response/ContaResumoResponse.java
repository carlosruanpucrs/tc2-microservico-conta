package com.carlosruanpucrs.tc2_microservico_conta.api.response;

import com.carlosruanpucrs.tc2_microservico_conta.enums.SituacaoContaEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContaResumoResponse {

    String documentoCliente;
    String nomeCliente;
    Integer numeroConta;
    SituacaoContaEnum situacao;
    LocalDate dataCriacao;
    BigDecimal saldo;
}
