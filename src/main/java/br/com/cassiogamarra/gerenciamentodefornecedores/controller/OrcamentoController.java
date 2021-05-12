package br.com.cassiogamarra.gerenciamentodefornecedores.controller;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.MessageResponseDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.OrcamentoDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.exception.OrcamentoNotFoundException;
import br.com.cassiogamarra.gerenciamentodefornecedores.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orcamentos")
public class OrcamentoController {

    private OrcamentoService orcamentoService;

    @Autowired
    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid OrcamentoDTO orcamentoDTO) {
        return orcamentoService.create(orcamentoDTO);
    }

    @PutMapping("/edit/{id}")
    public MessageResponseDTO edit(@PathVariable Long id, @RequestBody @Valid OrcamentoDTO orcamentoDTO) throws OrcamentoNotFoundException {
        return orcamentoService.edit(id, orcamentoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public MessageResponseDTO delete(@PathVariable Long id) throws OrcamentoNotFoundException {
        return orcamentoService.delete(id);
    }

    @GetMapping("/{id}")
    public OrcamentoDTO findById(@PathVariable Long id) throws OrcamentoNotFoundException {
        return orcamentoService.findById(id);
    }

    @GetMapping("/all")
    public List<OrcamentoDTO> findAll(){
        return orcamentoService.findAll();
    }
}
