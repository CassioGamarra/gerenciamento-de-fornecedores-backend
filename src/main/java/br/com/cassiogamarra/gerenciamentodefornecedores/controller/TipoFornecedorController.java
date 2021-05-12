package br.com.cassiogamarra.gerenciamentodefornecedores.controller;

import br.com.cassiogamarra.gerenciamentodefornecedores.dto.MessageResponseDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.dto.TipoFornecedorDTO;
import br.com.cassiogamarra.gerenciamentodefornecedores.exception.TipoFornecedorNotFoundException;
import br.com.cassiogamarra.gerenciamentodefornecedores.service.TipoFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/tiposfornecedores")
public class TipoFornecedorController {

    private TipoFornecedorService tipoFornecedorService;

    @Autowired
    public TipoFornecedorController(TipoFornecedorService tipoFornecedorService) {
        this.tipoFornecedorService = tipoFornecedorService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid TipoFornecedorDTO tipoFornecedorDTO) {
         return tipoFornecedorService.create(tipoFornecedorDTO);
    }

    @PutMapping("/edit/{id}")
    public MessageResponseDTO edit(@PathVariable Long id, @RequestBody @Valid TipoFornecedorDTO tipoFornecedorDTO) throws TipoFornecedorNotFoundException {
        return tipoFornecedorService.edit(id, tipoFornecedorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public MessageResponseDTO delete(@PathVariable Long id) throws TipoFornecedorNotFoundException {
        return tipoFornecedorService.delete(id);
    }

    @GetMapping("/{id}")
    public TipoFornecedorDTO findById(@PathVariable Long id) throws TipoFornecedorNotFoundException {
        return tipoFornecedorService.findById(id);
    }

    @GetMapping("/find/{descricao}")
    public TipoFornecedorDTO findByDescription(@PathVariable String descricao) throws TipoFornecedorNotFoundException {
        return tipoFornecedorService.findByDescricao(descricao);
    }

    @GetMapping("/all")
    public List<TipoFornecedorDTO> findAll(){
        return tipoFornecedorService.findAll();
    }
}
