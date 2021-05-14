package br.com.cassiogamarra.gerenciamentodefornecedores.service;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.MessageResponseDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.OrcamentoDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Orcamento;
import br.com.cassiogamarra.gerenciamentodefornecedores.exception.OrcamentoNotFoundException;
import br.com.cassiogamarra.gerenciamentodefornecedores.mapper.OrcamentoMapper;
import br.com.cassiogamarra.gerenciamentodefornecedores.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrcamentoService {

    private OrcamentoRepository orcamentoRepository;

    private final OrcamentoMapper orcamentoMapper = OrcamentoMapper.INSTANCE;

    @Autowired
    public OrcamentoService(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    public MessageResponseDTO create(OrcamentoDTO orcamentoDTO) {
        Orcamento orcamentoToSave = orcamentoMapper.toModel(orcamentoDTO);
        orcamentoRepository.save(orcamentoToSave);
        return MessageResponseDTO.builder()
                .message("Orçamento criado com sucesso!")
                .success(true)
                .build();
    }

    public MessageResponseDTO edit(Long id, OrcamentoDTO orcamentoDTO) throws OrcamentoNotFoundException {
        Orcamento orcamento = orcamentoRepository.findById(id)
                .orElseThrow(() -> new OrcamentoNotFoundException());

        //Transforma o body em um model
        Orcamento orcamentoToEdit = orcamentoMapper.toModel(orcamentoDTO);

        orcamento.setDescricao(orcamentoToEdit.getDescricao());
        orcamento.setValor(orcamentoToEdit.getValor());
        orcamento.setVencimento(orcamentoToEdit.getVencimento());
        orcamento.setFornecedor(orcamentoToEdit.getFornecedor());

        orcamentoRepository.save(orcamento);
        return MessageResponseDTO.builder()
                .message("Alterações salvas com sucesso!")
                .success(true)
                .build();
    }

    public MessageResponseDTO delete(Long id) throws OrcamentoNotFoundException {
        Orcamento orcamento  = orcamentoRepository.findById(id)
                .orElseThrow(() -> new OrcamentoNotFoundException());

        orcamentoRepository.delete(orcamento);
        return MessageResponseDTO.builder()
                .message("O orçamento foi excluído!")
                .success(true)
                .build();
    }

    public OrcamentoDTO findById(Long id) throws OrcamentoNotFoundException{
        Orcamento orcamento = orcamentoRepository.findById(id)
                .orElseThrow(() -> new OrcamentoNotFoundException());
        return orcamentoMapper.toDTO(orcamento);
    }

    public List<OrcamentoDTO> findAll() {
        List<Orcamento> orcamentoList = orcamentoRepository.findAll();

        List<OrcamentoDTO> orcamentoDTOList = new ArrayList<>(orcamentoList.size());

        for(Orcamento orcamento : orcamentoList) {
            orcamentoDTOList.add(orcamentoMapper.toDTO(orcamento));
        }

        return orcamentoDTOList;
    }
}
