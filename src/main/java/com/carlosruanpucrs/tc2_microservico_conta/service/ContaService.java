package com.carlosruanpucrs.tc2_microservico_conta.service;

import com.carlosruanpucrs.tc2_microservico_conta.api.request.ContratacaoContaRequest;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaResponse;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaResumoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.api.response.ContaSaldoResponse;
import com.carlosruanpucrs.tc2_microservico_conta.enums.TipoContaEnum;
import com.carlosruanpucrs.tc2_microservico_conta.exception.ContaNaoEncontradaException;
import com.carlosruanpucrs.tc2_microservico_conta.exception.DocumentoClienteNaoEncontradoException;
import com.carlosruanpucrs.tc2_microservico_conta.mapper.ContaMapper;
import com.carlosruanpucrs.tc2_microservico_conta.model.entity.ContaEntity;
import com.carlosruanpucrs.tc2_microservico_conta.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final ContaBacenService contaBacenService;
    private final ValidacaoContratacaoContaService validacaoContratacaoContaService;

    public ContaResumoResponse contratarConta(ContratacaoContaRequest request) {
        var numeroConta = gerarNumeroConta();
        var numeroBeneficio = gerarNumeroBeneficio(request.getTipoConta());
        var contaExistente = obtemContaPorDocumento(request.getNumeroDocumento());

        validacaoContratacaoContaService.validarDocumentoClienteExistente(contaExistente);
        validacaoContratacaoContaService.validarIdadeCliente(request.getDataNascimentoCliente());
        validacaoContratacaoContaService.validarCEP(request.getCep());

        var conta = ContaMapper.mapToContaEntity(request, numeroConta, numeroBeneficio);
        var contaSalva = contaRepository.insert(conta);

        contaBacenService.enviarNotificacaoAberturaConta(contaSalva);

        return ContaMapper.mapToContaResumoResponse(contaSalva);
    }

    private Integer gerarNumeroConta() {
        return (int) (Math.random() * 29);
    }

    private Integer gerarNumeroBeneficio(TipoContaEnum tipoConta) {
        return Objects.equals(TipoContaEnum.CONTA_BENEFICIO, tipoConta) ? gerarNumeroConta() * 2 : null;
    }

    public ContaSaldoResponse obtemSaldo(Integer numeroConta){
        var conta = obtemContaPorNumero(numeroConta);
        return ContaMapper.mapToContaSaldoResponse(conta);
    }

    public ContaResponse obtemDadosContaPorNumero(Integer numeroConta) {
        var conta = obtemContaPorNumero(numeroConta);
        return ContaMapper.mapToContaResponse(conta);
    }

    private ContaEntity obtemContaPorNumero(Integer numeroConta) {
        return contaRepository.findContaEntityByNumeroConta(numeroConta)
                .orElseThrow(() -> new ContaNaoEncontradaException(numeroConta));
    }

    private ContaEntity obtemContaPorDocumento(String numeroDocumento) {
        return contaRepository.findContaEntityByDocumentoCliente(numeroDocumento)
                .orElseThrow(() -> new DocumentoClienteNaoEncontradoException(numeroDocumento));
    }
}