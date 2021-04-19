package br.com.cassiogamarra.gerenciamentodefornecedores.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FORNECEDOR")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="CNPJ", nullable = false, unique = true)
    private String cnpj;
    @Column(name="NOME", nullable = false)
    private String nome;
    @Column(name="TELEFONE", nullable = false)
    private String telefone;
    @Column(name="CEP", nullable = false)
    private String cep;
    @Column(name="ENDERECO", nullable = false)
    private String endereco;
    @Column(name="BAIRRO", nullable = false)
    private String bairro;
    @Column(name="MUNICIPIO", nullable = false)
    private String municipio;
    @Column(name="UF", nullable = false)
    private String uf;
    @Column(name="STATUS", nullable = false)
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO")
    private TipoFornecedor tipoFornecedor;
}
