package com.carlosruanpucrs.tc2_microservico_conta.service;

import com.carlosruanpucrs.tc2_microservico_conta.exception.CepInvalidoException;
import com.carlosruanpucrs.tc2_microservico_conta.exception.DocumentoClienteExisteException;
import com.carlosruanpucrs.tc2_microservico_conta.exception.MenorIdadeException;
import com.carlosruanpucrs.tc2_microservico_conta.model.entity.ContaEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
@Service
public class ValidacaoContratacaoContaService {

    public void validarDocumentoClienteExistente(ContaEntity conta) {
        if (Objects.nonNull(conta)) {
            throw new DocumentoClienteExisteException(conta.getDocumentoCliente());
        }
    }

    public void validarIdadeCliente(LocalDate dataNascimento) {
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new MenorIdadeException();
        }
    }

    public void validarCEP(String cep) {
        if (Objects.isNull(cep) || !Pattern.matches("\\d{8}", cep)) {
            throw new CepInvalidoException(cep);
        }
    }
}
