package br.com.cassiogamarra.gerenciamentodefornecedores.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tipo_fornecedor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TipoFornecedor {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="descricao", nullable = false, unique = true)
    private String descricao;
}
