package br.com.cassiogamarra.gerenciamentodefornecedores.mapper;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.TipoFornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.TipoFornecedor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-20T22:41:25-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class TipoFornecedorMapperImpl implements TipoFornecedorMapper {

    @Override
    public TipoFornecedor toModel(TipoFornecedorDTO tipoFornecedorDTO) {
        if ( tipoFornecedorDTO == null ) {
            return null;
        }

        TipoFornecedor tipoFornecedor = new TipoFornecedor();

        tipoFornecedor.setId( tipoFornecedorDTO.getId() );
        tipoFornecedor.setDescricao( tipoFornecedorDTO.getDescricao() );

        return tipoFornecedor;
    }

    @Override
    public TipoFornecedorDTO toDTO(TipoFornecedor tipoFornecedor) {
        if ( tipoFornecedor == null ) {
            return null;
        }

        TipoFornecedorDTO tipoFornecedorDTO = new TipoFornecedorDTO();

        tipoFornecedorDTO.setId( tipoFornecedor.getId() );
        tipoFornecedorDTO.setDescricao( tipoFornecedor.getDescricao() );

        return tipoFornecedorDTO;
    }
}
