package br.com.curso.web.apirest.spring.various.codenation.biblioteca.controller;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Categoria;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAll() {
        return this.categoriaService.findAll();
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) {
        return this.categoriaService.save(categoria);
    }
}
