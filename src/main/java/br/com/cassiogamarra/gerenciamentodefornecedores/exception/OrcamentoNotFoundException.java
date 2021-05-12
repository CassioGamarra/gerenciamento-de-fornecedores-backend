package br.com.cassiogamarra.gerenciamentodefornecedores.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrcamentoNotFoundException extends Exception{

    public OrcamentoNotFoundException() {
        super(String.format("Orçamento não encontrado"));
    }
}
