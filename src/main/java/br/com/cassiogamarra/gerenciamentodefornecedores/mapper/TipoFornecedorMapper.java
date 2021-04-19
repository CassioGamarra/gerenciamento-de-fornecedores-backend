package br.com.cassiogamarra.gerenciamentodefornecedores.mapper;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.TipoFornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.TipoFornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoFornecedorMapper {

    TipoFornecedorMapper INSTANCE = Mappers.getMapper(TipoFornecedorMapper.class);

    TipoFornecedor toModel(TipoFornecedorDTO tipoFornecedorDTO);

    TipoFornecedorDTO toDTO(TipoFornecedor tipoFornecedor);

}
