package com.carlosruanpucrs.tc2_microservico_conta.client.response;

import com.carlosruanpucrs.tc2_microservico_conta.enums.TipoMovimentacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaResponse {

    String comprovante;
    Integer contaOrigem;
    Integer contaDestino;
    BigDecimal valor;
    LocalDateTime dataHora;
    TipoMovimentacaoEnum tipoMovimentacao;
}
