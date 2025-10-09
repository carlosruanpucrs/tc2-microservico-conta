package com.carlosruanpucrs.tc2_microservico_conta.api;

import com.carlosruanpucrs.tc2_microservico_conta.api.request.ContratacaoContaRequest;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaResumoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.service.ContaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/contas")
public class ContaApi {

    private final ContaService contaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ContaResumoResponse> contratarConta(@RequestBody ContratacaoContaRequest request) {
        return ResponseEntity.ok(contaService.contratarConta(request));
    }
}
