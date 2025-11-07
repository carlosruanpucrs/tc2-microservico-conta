package com.carlosruanpucrs.tc2_microservico_conta.client;

import com.carlosruanpucrs.tc2_microservico_conta.client.response.TransferenciaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@Component
@FeignClient(name = "transacao-service", path = "/v1/transferencias")
public interface TransacaoClient {

    @GetMapping("/{numeroConta}")
    ResponseEntity<List<TransferenciaResponse>> listarTransferenciasPorConta(@PathVariable Integer numeroConta);
}
