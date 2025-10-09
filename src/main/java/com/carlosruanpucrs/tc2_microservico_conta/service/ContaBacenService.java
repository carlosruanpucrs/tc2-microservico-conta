package com.carlosruanpucrs.tc2_microservico_conta.service;

import com.carlosruanpucrs.tc2_microservico_conta.mapper.ContaMapper;
import com.carlosruanpucrs.tc2_microservico_conta.message.producer.ContaBacenProducer;
import com.carlosruanpucrs.tc2_microservico_conta.model.entity.ContaEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContaBacenService {

    private final ContaBacenProducer contaBacenProducer;

    public void enviarNotificacaoAberturaConta(ContaEntity conta){
        var eventoAux = ContaMapper.mapToContaNotificacaoBacenEvent(conta);
        contaBacenProducer.enviar(eventoAux);
    }
}