package com.carlosruanpucrs.tc2_microservico_conta.api;

import com.carlosruanpucrs.tc2_microservico_conta.api.request.ContratacaoContaRequest;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaResponse;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaResumoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaSaldoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.enums.OperacaoTransacaoEnum;
import com.carlosruanpucrs.tc2_microservico_conta.service.ContaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/contas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContaApi {

    private final ContaService contaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ContaResumoResponse> contratarConta(@RequestBody ContratacaoContaRequest request) {
        return ResponseEntity.ok(contaService.contratarConta(request));
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<ContaResponse> contaPorNumero(@PathVariable Integer numeroConta) {
        return ResponseEntity.ok(contaService.obtemDadosContaPorNumero(numeroConta));
    }

    @GetMapping("/{numeroConta}/saldo")
    public ResponseEntity<ContaSaldoResponse> saldoConta(@PathVariable Integer numeroConta) {
        return ResponseEntity.ok(contaService.obtemSaldo(numeroConta));
    }

    @PatchMapping("/{numeroConta}/saldo/atualizacao")
    public ResponseEntity<Void> atualizarSaldo(@PathVariable Integer numeroConta,
                                               @RequestParam("valor") BigDecimal valor,
                                               @RequestParam("operacaoTransacao") OperacaoTransacaoEnum operacaoTransacao) {
        contaService.atualizarSaldo(numeroConta, valor, operacaoTransacao);
        return ResponseEntity.noContent().build();
    }
}
