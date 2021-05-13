package br.com.cassiogamarra.gerenciamentodefornecedores.mapper;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.FornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.TipoFornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Fornecedor;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.TipoFornecedor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-13T00:20:00-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class FornecedorMapperImpl implements FornecedorMapper {

    @Override
    public Fornecedor toModel(FornecedorDTO fornecedorDTO) {
        if ( fornecedorDTO == null ) {
            return null;
        }

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setId( fornecedorDTO.getId() );
        fornecedor.setCnpj( fornecedorDTO.getCnpj() );
        fornecedor.setNome( fornecedorDTO.getNome() );
        fornecedor.setTelefone( fornecedorDTO.getTelefone() );
        fornecedor.setCep( fornecedorDTO.getCep() );
        fornecedor.setEndereco( fornecedorDTO.getEndereco() );
        fornecedor.setBairro( fornecedorDTO.getBairro() );
        fornecedor.setMunicipio( fornecedorDTO.getMunicipio() );
        fornecedor.setUf( fornecedorDTO.getUf() );
        fornecedor.setStatus( fornecedorDTO.isStatus() );
        fornecedor.setTipoFornecedor( tipoFornecedorDTOToTipoFornecedor( fornecedorDTO.getTipoFornecedor() ) );

        return fornecedor;
    }

    @Override
    public FornecedorDTO toDTO(Fornecedor fornecedor) {
        if ( fornecedor == null ) {
            return null;
        }

        FornecedorDTO fornecedorDTO = new FornecedorDTO();

        fornecedorDTO.setId( fornecedor.getId() );
        fornecedorDTO.setCnpj( fornecedor.getCnpj() );
        fornecedorDTO.setNome( fornecedor.getNome() );
        fornecedorDTO.setTelefone( fornecedor.getTelefone() );
        fornecedorDTO.setCep( fornecedor.getCep() );
        fornecedorDTO.setEndereco( fornecedor.getEndereco() );
        fornecedorDTO.setBairro( fornecedor.getBairro() );
        fornecedorDTO.setMunicipio( fornecedor.getMunicipio() );
        fornecedorDTO.setUf( fornecedor.getUf() );
        fornecedorDTO.setStatus( fornecedor.isStatus() );
        fornecedorDTO.setTipoFornecedor( tipoFornecedorToTipoFornecedorDTO( fornecedor.getTipoFornecedor() ) );

        return fornecedorDTO;
    }

    protected TipoFornecedor tipoFornecedorDTOToTipoFornecedor(TipoFornecedorDTO tipoFornecedorDTO) {
        if ( tipoFornecedorDTO == null ) {
            return null;
        }

        TipoFornecedor tipoFornecedor = new TipoFornecedor();

        tipoFornecedor.setId( tipoFornecedorDTO.getId() );
        tipoFornecedor.setDescricao( tipoFornecedorDTO.getDescricao() );

        return tipoFornecedor;
    }

    protected TipoFornecedorDTO tipoFornecedorToTipoFornecedorDTO(TipoFornecedor tipoFornecedor) {
        if ( tipoFornecedor == null ) {
            return null;
        }

        TipoFornecedorDTO tipoFornecedorDTO = new TipoFornecedorDTO();

        tipoFornecedorDTO.setId( tipoFornecedor.getId() );
        tipoFornecedorDTO.setDescricao( tipoFornecedor.getDescricao() );

        return tipoFornecedorDTO;
    }
}
