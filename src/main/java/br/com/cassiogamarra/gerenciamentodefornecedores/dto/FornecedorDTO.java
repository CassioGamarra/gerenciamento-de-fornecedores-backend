package br.com.cassiogamarra.gerenciamentodefornecedores.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {

    private Long id;

    @NotBlank
    @Size(max = 18)
    private String cnpj;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String telefone;

    @NotBlank
    @Size(max = 12)
    private String cep;

    @NotBlank
    @Size(max = 255)
    private String endereco;

    @NotBlank
    @Size(max = 50)
    private String bairro;

    @NotBlank
    @Size(max = 100)
    private String municipio;

    @NotBlank
    @Size(max = 3)
    private String uf;

    @NotNull
    private boolean status;

    @NotNull
    private TipoFornecedorDTO tipoFornecedor;
}
