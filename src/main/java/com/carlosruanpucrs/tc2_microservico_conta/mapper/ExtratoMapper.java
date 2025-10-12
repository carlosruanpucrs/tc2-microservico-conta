package com.carlosruanpucrs.tc2_microservico_conta.mapper;

import com.carlosruanpucrs.tc2_microservico_conta.api.response.ExtratoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.client.response.TransferenciaResponse;
import com.carlosruanpucrs.tc2_microservico_conta.enums.OperacaoTransacaoEnum;
import com.carlosruanpucrs.tc2_microservico_conta.model.dto.TransferenciaDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static com.carlosruanpucrs.tc2_microservico_conta.enums.OperacaoTransacaoEnum.CREDITO;
import static com.carlosruanpucrs.tc2_microservico_conta.enums.OperacaoTransacaoEnum.DEBITO;

public class ExtratoMapper {

    public static ExtratoResponse mapToExtratoResponse(Integer numeroConta, BigDecimal saldo, List<TransferenciaResponse> transferencias) {
        return ExtratoResponse.builder()
                .numeroContaOrigem(numeroConta)
                .saldo(saldo)
                .transferencias(mapToTransferenciaResponseList(numeroConta, transferencias))
                .build();
    }

    private static List<TransferenciaDTO> mapToTransferenciaResponseList(Integer numeroConta, List<TransferenciaResponse> transferencias) {
        return transferencias.stream()
                .map(t -> mapToTransferenciaResponse(numeroConta, t))
                .toList();
    }

    public static TransferenciaDTO mapToTransferenciaResponse(Integer numeroConta, TransferenciaResponse transferencia) {
        return TransferenciaDTO.builder()
                .comprovante(transferencia.getComprovante())
                .valor(transferencia.getValor())
                .dataHora(transferencia.getDataHora())
                .numeroConta(transferencia.getContaDestino())
                .operacao(obtemOperacao(numeroConta, transferencia.getContaOrigem()))
                .tipoMovimentacao(transferencia.getTipoMovimentacao())
                .build();
    }

    private static OperacaoTransacaoEnum obtemOperacao(Integer numeroConta, Integer numeroContaOrigem) {
        return Objects.equals(numeroConta, numeroContaOrigem)
                ? CREDITO
                : DEBITO;
    }

}
