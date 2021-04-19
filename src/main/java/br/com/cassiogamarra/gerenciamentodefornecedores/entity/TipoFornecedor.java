package br.com.cassiogamarra.gerenciamentodefornecedores.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO_FORNECEDOR")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TipoFornecedor {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="DESCRICAO", nullable = false, unique = true)
    private String descricao;
}
