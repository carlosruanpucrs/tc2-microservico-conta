package com.carlosruanpucrs.tc2_microservico_conta.mapper;

import com.carlosruanpucrs.tc2_microservico_conta.api.request.ContratacaoContaRequest;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaResponse;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaResumoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaSaldoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.client.request.AberturaContaNotificacaoCcsRequest;
import com.carlosruanpucrs.tc2_microservico_conta.enums.SituacaoContaEnum;
import com.carlosruanpucrs.tc2_microservico_conta.model.entity.ContaEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ContaMapper {

    public static ContaEntity mapToContaEntity(ContratacaoContaRequest request, Integer numeroConta, Integer numeroBeneficio) {
        return ContaEntity.builder()
                .documentoCliente(request.getNumeroDocumento())
                .nomeCliente(request.getNomeCliente())
                .numeroConta(numeroConta)
                .dataCriacao(LocalDate.now())
                .saldo(BigDecimal.ZERO)
                .saldoBloqueado(BigDecimal.ZERO)
                .situacao(SituacaoContaEnum.ATIVA)
                .tipoConta(request.getTipoConta())
                .numeroBeneficio(numeroBeneficio)
                .build();
    }

    public static ContaResumoResponse mapToContaResumoResponse(ContaEntity contaEntity) {
        return ContaResumoResponse.builder()
                .documentoCliente(contaEntity.getDocumentoCliente())
                .nomeCliente(contaEntity.getNomeCliente())
                .numeroConta(contaEntity.getNumeroConta())
                .dataCriacao(contaEntity.getDataCriacao())
                .saldo(contaEntity.getSaldo())
                .situacao(contaEntity.getSituacao())
                .build();
    }

    public static ContaSaldoResponse mapToContaSaldoResponse(ContaEntity contaEntity) {
        return ContaSaldoResponse.builder()
                .saldo(contaEntity.getSaldo())
                .saldoBloqueado(contaEntity.getSaldoBloqueado())
                .build();
    }

    public static ContaResponse mapToContaResponse(ContaEntity conta) {
        return ContaResponse.builder()
                .documentoCliente(conta.getDocumentoCliente())
                .tipoConta(conta.getTipoConta())
                .numeroConta(conta.getNumeroConta())
                .numeroBeneficio(conta.getNumeroBeneficio())
                .dataCriacao(conta.getDataCriacao())
                .situacao(conta.getSituacao())
                .build();
    }

    public static AberturaContaNotificacaoCcsRequest mapToAberturaContaNotificacaoCcsRequest(ContaEntity contaEntity) {
        return AberturaContaNotificacaoCcsRequest.builder()
                .idTransacao(UUID.randomUUID().toString())
                .dataAberturaConta(contaEntity.getDataCriacao())
                .numeroDocumentoCliente(contaEntity.getDocumentoCliente())
                .numeroConta(contaEntity.getNumeroConta())
                .nomeBanco("BITBANK")
                .build();
    }
}