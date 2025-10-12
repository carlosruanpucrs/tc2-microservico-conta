package com.carlosruanpucrs.tc2_microservico_conta.model.dto;

import com.carlosruanpucrs.tc2_microservico_conta.enums.OperacaoTransacaoEnum;
import com.carlosruanpucrs.tc2_microservico_conta.enums.TipoMovimentacaoEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferenciaDTO {

    String comprovante;
    Integer numeroConta;
    BigDecimal valor;
    LocalDateTime dataHora;
    OperacaoTransacaoEnum operacao;
    TipoMovimentacaoEnum tipoMovimentacao;
}