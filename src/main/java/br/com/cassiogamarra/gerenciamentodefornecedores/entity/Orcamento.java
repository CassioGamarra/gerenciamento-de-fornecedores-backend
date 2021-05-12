package br.com.cassiogamarra.gerenciamentodefornecedores.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orcamento")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Orcamento {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="descricao", nullable = false)
    private String descricao;

    @Column(name="valor", nullable = false)
    private double valor;

    @Column(name="vencimento", nullable = false)
    private Date vencimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
}
