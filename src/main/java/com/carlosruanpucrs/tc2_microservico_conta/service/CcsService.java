package com.carlosruanpucrs.tc2_microservico_conta.service;

import com.carlosruanpucrs.tc2_microservico_conta.client.CcsClient;
import com.carlosruanpucrs.tc2_microservico_conta.mapper.ContaMapper;
import com.carlosruanpucrs.tc2_microservico_conta.model.entity.ContaEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CcsService {

    private final CcsClient ccsClient;

    public void enviarNotificacaoAberturaConta(ContaEntity conta){
        var request = ContaMapper.mapToAberturaContaNotificacaoCcsRequest(conta);
        ccsClient.notificarAberturaConta(request);
    }
}