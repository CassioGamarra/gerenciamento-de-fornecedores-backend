package br.com.cassiogamarra.gerenciamentodefornecedores.service;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.MessageResponseDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.TipoFornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.TipoFornecedor;
import br.com.cassiogamarra.gerenciamentodefornecedores.exception.TipoFornecedorNotFoundException;
import br.com.cassiogamarra.gerenciamentodefornecedores.mapper.TipoFornecedorMapper;
import br.com.cassiogamarra.gerenciamentodefornecedores.repository.TipoFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoFornecedorService {

    private TipoFornecedorRepository tipoFornecedorRepository;

    private final TipoFornecedorMapper tipoFornecedorMapper = TipoFornecedorMapper.INSTANCE;

    @Autowired
    public TipoFornecedorService(TipoFornecedorRepository tipoFornecedorRepository) {
        this.tipoFornecedorRepository = tipoFornecedorRepository;
    }

    public MessageResponseDTO create(TipoFornecedorDTO tipoFornecedorDTO) {
        boolean hasService = tipoFornecedorRepository.findByDescricao(tipoFornecedorDTO.getDescricao()).isEmpty();
        if(hasService) {
            TipoFornecedor tipoFornecedorToSave = tipoFornecedorMapper.toModel(tipoFornecedorDTO);
            tipoFornecedorRepository.save(tipoFornecedorToSave);
            return MessageResponseDTO.builder()
                    .message("Tipo de fornecedor criado com sucesso!")
                    .success(true)
                    .build();
        } else {
            return MessageResponseDTO.builder()
                    .message("Já existe um tipo de serviço cadastrado com essa descrição!")
                    .success(false)
                    .build();
        }
    }

    public MessageResponseDTO edit(Long id, TipoFornecedorDTO tipoFornecedorDTO) throws TipoFornecedorNotFoundException {
        TipoFornecedor tipoFornecedor = tipoFornecedorRepository.findById(id)
                .orElseThrow(() -> new TipoFornecedorNotFoundException());

        //Transforma o body em um model
        TipoFornecedor tipoFornecedorToEdit = tipoFornecedorMapper.toModel(tipoFornecedorDTO);

        tipoFornecedor.setDescricao(tipoFornecedorToEdit.getDescricao());

        tipoFornecedorRepository.save(tipoFornecedor);
        return MessageResponseDTO.builder()
                .message("Alterações salvas com sucesso!")
                .success(true)
                .build();
    }

    public MessageResponseDTO delete(Long id) throws TipoFornecedorNotFoundException {
        TipoFornecedor tipoFornecedor = tipoFornecedorRepository.findById(id)
                .orElseThrow(() -> new TipoFornecedorNotFoundException());

        tipoFornecedorRepository.delete(tipoFornecedor);
        return MessageResponseDTO.builder()
                .message("O tipoFornecedor foi excluído!")
                .success(true)
                .build();
    }

    public TipoFornecedorDTO findById(Long id) throws TipoFornecedorNotFoundException{
        TipoFornecedor tipoFornecedor = tipoFornecedorRepository.findById(id)
                .orElseThrow(() -> new TipoFornecedorNotFoundException());
        return tipoFornecedorMapper.toDTO(tipoFornecedor);
    }

    public TipoFornecedorDTO findByDescricao(String descricao) throws TipoFornecedorNotFoundException{
        TipoFornecedor tipoFornecedor  = tipoFornecedorRepository.findByDescricao(descricao)
                .orElseThrow(() -> new TipoFornecedorNotFoundException());
        return tipoFornecedorMapper.toDTO(tipoFornecedor);
    }

    public List<TipoFornecedorDTO> findAll() {
        List<TipoFornecedor> tipoFornecedorList = tipoFornecedorRepository.findAll();

        List<TipoFornecedorDTO> tipoFornecedorDTOList = new ArrayList<>(tipoFornecedorList.size());

        for(TipoFornecedor tipoFornecedor : tipoFornecedorList) {
            tipoFornecedorDTOList.add(tipoFornecedorMapper.toDTO(tipoFornecedor));
        }

        return tipoFornecedorDTOList;
    }
}
