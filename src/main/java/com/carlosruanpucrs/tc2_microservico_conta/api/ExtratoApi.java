package com.carlosruanpucrs.tc2_microservico_conta.api;

import com.carlosruanpucrs.tc2_microservico_conta.api.response.ExtratoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.service.ContaService;
import com.carlosruanpucrs.tc2_microservico_conta.service.ExtratoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/extratos")
public class ExtratoApi {

    private final ContaService contaService;

    @GetMapping("/{numeroConta}")
    public ResponseEntity<ExtratoResponse> consultarExtrato(@PathVariable Integer numeroConta) {
        return ResponseEntity.ok(contaService.gerarExtrato(numeroConta));
    }
}
