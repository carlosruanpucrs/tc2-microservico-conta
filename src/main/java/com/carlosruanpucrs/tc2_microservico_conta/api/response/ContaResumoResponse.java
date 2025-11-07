package com.carlosruanpucrs.tc2_microservico_conta.api.response;

import com.carlosruanpucrs.tc2_microservico_conta.enums.SituacaoContaEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContaResumoResponse implements Serializable {

    String documentoCliente;
    String nomeCliente;
    Integer numeroConta;
    SituacaoContaEnum situacao;
    LocalDate dataCriacao;
    BigDecimal saldo;
}
