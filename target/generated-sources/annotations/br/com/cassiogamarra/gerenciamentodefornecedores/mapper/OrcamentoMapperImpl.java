package br.com.cassiogamarra.gerenciamentodefornecedores.mapper;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.FornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.OrcamentoDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.TipoFornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Fornecedor;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Orcamento;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.TipoFornecedor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-13T00:20:01-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class OrcamentoMapperImpl implements OrcamentoMapper {

    @Override
    public Orcamento toModel(OrcamentoDTO orcamentoDTO) {
        if ( orcamentoDTO == null ) {
            return null;
        }

        Orcamento orcamento = new Orcamento();

        orcamento.setId( orcamentoDTO.getId() );
        orcamento.setDescricao( orcamentoDTO.getDescricao() );
        orcamento.setValor( orcamentoDTO.getValor() );
        orcamento.setVencimento( orcamentoDTO.getVencimento() );
        orcamento.setFornecedor( fornecedorDTOToFornecedor( orcamentoDTO.getFornecedor() ) );

        return orcamento;
    }

    @Override
    public OrcamentoDTO toDTO(Orcamento orcamento) {
        if ( orcamento == null ) {
            return null;
        }

        OrcamentoDTO orcamentoDTO = new OrcamentoDTO();

        orcamentoDTO.setId( orcamento.getId() );
        orcamentoDTO.setDescricao( orcamento.getDescricao() );
        orcamentoDTO.setValor( orcamento.getValor() );
        orcamentoDTO.setVencimento( orcamento.getVencimento() );
        orcamentoDTO.setFornecedor( fornecedorToFornecedorDTO( orcamento.getFornecedor() ) );

        return orcamentoDTO;
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

    protected Fornecedor fornecedorDTOToFornecedor(FornecedorDTO fornecedorDTO) {
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

    protected TipoFornecedorDTO tipoFornecedorToTipoFornecedorDTO(TipoFornecedor tipoFornecedor) {
        if ( tipoFornecedor == null ) {
            return null;
        }

        TipoFornecedorDTO tipoFornecedorDTO = new TipoFornecedorDTO();

        tipoFornecedorDTO.setId( tipoFornecedor.getId() );
        tipoFornecedorDTO.setDescricao( tipoFornecedor.getDescricao() );

        return tipoFornecedorDTO;
    }

    protected FornecedorDTO fornecedorToFornecedorDTO(Fornecedor fornecedor) {
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
}
