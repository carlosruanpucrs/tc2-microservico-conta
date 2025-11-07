package com.carlosruanpucrs.tc2_microservico_conta.api.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContaSaldoResponse {

    BigDecimal saldo;
    BigDecimal saldoBloqueado;
}
