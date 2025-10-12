package com.carlosruanpucrs.tc2_microservico_conta.service;

import com.carlosruanpucrs.tc2_microservico_conta.api.response.ExtratoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.client.TransacaoClient;
import com.carlosruanpucrs.tc2_microservico_conta.mapper.ExtratoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExtratoService {

    private final TransacaoClient transacaoClient;

    public ExtratoResponse gerarExtrato(Integer numeroConta, BigDecimal saldoConta) {
        var transacoes = null; //transacaoClient
        return ExtratoMapper.mapToExtratoResponse(numeroConta, saldoConta, transacoes);
    }
}
