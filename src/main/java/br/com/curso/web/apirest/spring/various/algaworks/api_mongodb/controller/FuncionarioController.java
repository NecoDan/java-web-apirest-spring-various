package br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.controller;

import br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.model.Funcionario;
import br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.service.IFuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final IFuncionarioService funcionarioService;

    @GetMapping("/")
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.buscarTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
        return this.funcionarioService
                .buscarPorId(codigo).orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado e/ou inexistente."));
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.salvar(funcionario);
    }
}
