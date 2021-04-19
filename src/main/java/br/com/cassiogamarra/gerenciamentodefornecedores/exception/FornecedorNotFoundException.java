package br.com.cassiogamarra.gerenciamentodefornecedores.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FornecedorNotFoundException extends Exception {
    public FornecedorNotFoundException() {
        super(String.format("Fornecedor não encontrado"));
    }
}
