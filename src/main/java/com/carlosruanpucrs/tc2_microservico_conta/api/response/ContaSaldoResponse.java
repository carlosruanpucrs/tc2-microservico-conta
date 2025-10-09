package com.carlosruanpucrs.tc2_microservico_conta.api.response;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContaSaldoResponse {

    Integer numeroConta;
    BigDecimal saldo;
    BigDecimal saldoBloqueado;

}
