package br.com.curso.web.apirest.spring.various.codenation.biblioteca.controller;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Avaliacao;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.service.IAvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final IAvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> findAll() {
        return this.avaliacaoService.findAll();
    }

    @PostMapping
    public Avaliacao save(@RequestBody Avaliacao avaliacao) {
        return this.avaliacaoService.save(avaliacao);
    }
}
