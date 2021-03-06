package br.com.cassiogamarra.gerenciamentodefornecedores.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoFornecedorDTO {

    private Long id;

    @NotBlank
    @Size(max = 200)
    private String descricao;
}
