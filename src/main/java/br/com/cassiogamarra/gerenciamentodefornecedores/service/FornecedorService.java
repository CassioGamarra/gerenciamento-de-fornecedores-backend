package br.com.cassiogamarra.gerenciamentodefornecedores.service;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.FornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.MessageResponseDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.entity.Fornecedor;
import br.com.cassiogamarra.gerenciamentodefornecedores.exception.FornecedorNotFoundException;
import br.com.cassiogamarra.gerenciamentodefornecedores.mapper.FornecedorMapper;
import br.com.cassiogamarra.gerenciamentodefornecedores.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    private final FornecedorMapper fornecedorMapper = FornecedorMapper.INSTANCE;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public MessageResponseDTO create(FornecedorDTO fornecedorDTO) {
        //Verifica se já existe um fornecedor, se isEmpty == true, nao achou nenhum
        boolean hasFornecedor = fornecedorRepository.findByCnpj(fornecedorDTO.getCnpj()).isEmpty();

        if(hasFornecedor) {
            Fornecedor fornecedorToSave = fornecedorMapper.toModel(fornecedorDTO);
            Fornecedor savedFornecedor = fornecedorRepository.save(fornecedorToSave);
            return MessageResponseDTO.builder()
                    .message("Fornecedor criado com o ID "+savedFornecedor.getId())
                    .success(true)
                    .build();
        } else {
            return MessageResponseDTO.builder()
                    .message("Já existe um fornecedor com este CNPJ!")
                    .success(false)
                    .build();
        }
    }

    public MessageResponseDTO edit(Long id, FornecedorDTO fornecedorDTO) throws FornecedorNotFoundException {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new FornecedorNotFoundException());

        //Transforma o body em um model
        Fornecedor fornecedorToEdit = fornecedorMapper.toModel(fornecedorDTO);

        fornecedor.setNome(fornecedorToEdit.getNome());
        fornecedor.setTelefone(fornecedorToEdit.getTelefone());
        fornecedor.setMunicipio(fornecedorToEdit.getMunicipio());
        fornecedor.setCep(fornecedorToEdit.getCep());
        fornecedor.setEndereco(fornecedorToEdit.getEndereco());
        fornecedor.setBairro(fornecedorToEdit.getBairro());
        fornecedor.setMunicipio(fornecedorToEdit.getMunicipio());
        fornecedor.setUf(fornecedorToEdit.getUf());
        fornecedor.setTipoFornecedor(fornecedorToEdit.getTipoFornecedor());

        fornecedorRepository.save(fornecedor);
        return MessageResponseDTO.builder()
                .message("Alterações salvas com sucesso!")
                .success(true)
                .build();
    }


    public MessageResponseDTO disable(Long id) throws FornecedorNotFoundException {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new FornecedorNotFoundException());
        fornecedor.setStatus(false);
        fornecedorRepository.save(fornecedor);
        return MessageResponseDTO.builder()
                .message("Fornecedor desabilitado!")
                .build();
    }

    public MessageResponseDTO enable(Long id) throws FornecedorNotFoundException {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new FornecedorNotFoundException());
        fornecedor.setStatus(true);
        fornecedorRepository.save(fornecedor);
        return MessageResponseDTO.builder()
                .message("Fornecedor habilitado!")
                .build();
    }

    public MessageResponseDTO delete(Long id) throws FornecedorNotFoundException {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new FornecedorNotFoundException());

        fornecedorRepository.delete(fornecedor);
        return MessageResponseDTO.builder()
                .message("O fornecedor foi deletado!")
                .build();
    }

    public FornecedorDTO findById(Long id) throws FornecedorNotFoundException {
       Fornecedor fornecedor = fornecedorRepository.findById(id)
               .orElseThrow(() -> new FornecedorNotFoundException());
       return fornecedorMapper.toDTO(fornecedor);
    }

    public FornecedorDTO findByCnpj(String cnpj) throws FornecedorNotFoundException{
        Fornecedor fornecedor  = fornecedorRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new FornecedorNotFoundException());
        return fornecedorMapper.toDTO(fornecedor);
    }

    public List<FornecedorDTO> findAll() {
        List<Fornecedor> fornecedorList = fornecedorRepository.findAll();

        List<FornecedorDTO> fornecedorDTOList = new ArrayList<>(fornecedorList.size());

        for(Fornecedor fornecedor : fornecedorList) {
            fornecedorDTOList.add(fornecedorMapper.toDTO(fornecedor));
        }

        return fornecedorDTOList;
    }
}
