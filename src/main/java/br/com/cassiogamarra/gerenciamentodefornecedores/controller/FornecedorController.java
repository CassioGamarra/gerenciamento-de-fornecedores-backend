package br.com.cassiogamarra.gerenciamentodefornecedores.controller;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.FornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.MessageResponseDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.TipoFornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.exception.FornecedorNotFoundException;
import br.com.cassiogamarra.gerenciamentodefornecedores.service.FornecedorService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/fornecedores")
public class FornecedorController {

    private FornecedorService fornecedorService;

    @Autowired
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid FornecedorDTO fornecedorDTO) {
         return fornecedorService.create(fornecedorDTO);
    }

    @PutMapping("/edit/{id}")
    public MessageResponseDTO edit(@PathVariable Long id, @RequestBody @Valid FornecedorDTO fornecedorDTO) throws FornecedorNotFoundException {
        return fornecedorService.edit(id, fornecedorDTO);
    }

    @PutMapping("/disable/{id}")
    public MessageResponseDTO disable(@PathVariable Long id) throws FornecedorNotFoundException {
        return fornecedorService.disable(id);
    }

    @PutMapping("/enable/{id}")
    public MessageResponseDTO enable(@PathVariable Long id) throws FornecedorNotFoundException {
        return fornecedorService.enable(id);
    }

    @DeleteMapping("/delete/{id}")
    public MessageResponseDTO delete(@PathVariable Long id) throws FornecedorNotFoundException {
        return fornecedorService.delete(id);
    }

    @GetMapping("/{id}")
    public FornecedorDTO findById(@PathVariable Long id) throws FornecedorNotFoundException {
        return fornecedorService.findById(id);
    }

    @GetMapping("/cnpj/{cnpj}")
    public FornecedorDTO findByCnpj(@PathVariable String cnpj) throws FornecedorNotFoundException{
        return fornecedorService.findByCnpj(cnpj);
    }

    @GetMapping("/all")
    public List<FornecedorDTO> findAll(){
        return fornecedorService.findAll();
    }
}
