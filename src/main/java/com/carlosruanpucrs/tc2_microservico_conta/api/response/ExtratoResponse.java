package com.carlosruanpucrs.tc2_microservico_conta.api.response;


import com.carlosruanpucrs.tc2_microservico_conta.model.dto.TransferenciaDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExtratoResponse {

    Integer numeroContaOrigem;
    BigDecimal saldo;
    List<TransferenciaDTO> transferencias;
}