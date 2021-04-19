package br.com.cassiogamarra.gerenciamentodefornecedores.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TipoFornecedorNotFoundException extends Exception {
    public TipoFornecedorNotFoundException() {
        super(String.format("Tipo de fornecedor não encontrado"));
    }
}
