package br.com.cassiogamarra.gerenciamentodefornecedores.dto;

import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoDTO {

    private Long id;

    @NotBlank
    @Size(max=200)
    private String descricao;

    @NotNull
    private double valor;

    @NotNull
    private Date vencimento;

    @NotNull
    private FornecedorDTO fornecedor;
}
