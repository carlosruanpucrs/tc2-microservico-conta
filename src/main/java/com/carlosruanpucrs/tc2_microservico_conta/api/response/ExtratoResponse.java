package com.carlosruanpucrs.tc2_microservico_conta.api.response;


import com.carlosruanpucrs.tc2_microservico_conta.model.dto.TransferenciaDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExtratoResponse {

    Integer numeroContaOrigem;
    BigDecimal saldo;
    List<TransferenciaDTO> transferencias;
}