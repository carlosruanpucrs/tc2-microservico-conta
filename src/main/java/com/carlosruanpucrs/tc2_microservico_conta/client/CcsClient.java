package com.carlosruanpucrs.tc2_microservico_conta.client;

import com.carlosruanpucrs.tc2_microservico_conta.client.request.AberturaContaNotificacaoCcsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ccs-service", path = "/v1/ccs")
public interface CcsClient {

    @PostMapping("/notificacao/abertura")
    ResponseEntity<Void> notificarAberturaConta(@RequestBody AberturaContaNotificacaoCcsRequest request);
}
