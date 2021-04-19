package br.com.cassiogamarra.gerenciamentodefornecedores.mapper;


import br.com.cassiogamarra.gerenciamentodefornecedores.dto.FornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FornecedorMapper {

    FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);

    Fornecedor toModel(FornecedorDTO fornecedorDTO);

    FornecedorDTO toDTO(Fornecedor fornecedor);

}
