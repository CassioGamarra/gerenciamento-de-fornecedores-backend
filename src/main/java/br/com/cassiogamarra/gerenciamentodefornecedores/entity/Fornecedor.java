package br.com.cassiogamarra.gerenciamentodefornecedores.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fornecedor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="telefone", nullable = false)
    private String telefone;

    @Column(name="cep", nullable = false)
    private String cep;

    @Column(name="endereco", nullable = false)
    private String endereco;

    @Column(name="bairro", nullable = false)
    private String bairro;

    @Column(name="municipio", nullable = false)
    private String municipio;

    @Column(name="uf", nullable = false)
    private String uf;

    @Column(name="status", nullable = false)
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
    private TipoFornecedor tipoFornecedor;
}
