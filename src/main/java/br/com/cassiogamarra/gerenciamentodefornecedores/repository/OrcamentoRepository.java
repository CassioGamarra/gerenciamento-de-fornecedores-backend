package br.com.cassiogamarra.gerenciamentodefornecedores.repository;

import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
}
