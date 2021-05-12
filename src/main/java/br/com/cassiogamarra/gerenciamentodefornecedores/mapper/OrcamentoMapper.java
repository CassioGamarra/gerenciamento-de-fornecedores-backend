package br.com.cassiogamarra.gerenciamentodefornecedores.mapper;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.OrcamentoDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Orcamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrcamentoMapper {

    OrcamentoMapper INSTANCE = Mappers.getMapper(OrcamentoMapper.class);

    Orcamento toModel(OrcamentoDTO orcamentoDTO);

    OrcamentoDTO toDTO(Orcamento orcamento);
}
