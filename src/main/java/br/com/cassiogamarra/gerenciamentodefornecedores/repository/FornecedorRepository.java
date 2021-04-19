package br.com.cassiogamarra.gerenciamentodefornecedores.repository;

import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    Optional<Fornecedor> findByCnpj(String cnpj);
}
