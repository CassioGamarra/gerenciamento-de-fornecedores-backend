package br.com.cassiogamarra.gerenciamentodefornecedores.repository;


import br.com.cassiogamarra.gerenciamentodefornecedores.entity.TipoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoFornecedorRepository extends JpaRepository<TipoFornecedor, Long> {

    Optional<TipoFornecedor> findByDescricao(String descricao);
}
