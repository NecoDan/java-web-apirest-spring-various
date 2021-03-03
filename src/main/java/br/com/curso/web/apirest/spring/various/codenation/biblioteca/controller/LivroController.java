package br.com.curso.web.apirest.spring.various.codenation.biblioteca.controller;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Livro;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.service.ILivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final ILivroService livroService;

    @PostMapping
    public Livro save(@RequestBody Livro livro) {
        return this.livroService.save(livro);
    }

    @GetMapping
    public Iterable<Livro> findAll() {
        return this.livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro findById(@PathVariable("id") Long id) {
        return this.livroService.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.livroService.deleteById(id);
    }

    @GetMapping("/byCategoria/{id}")
    public List<Livro> findByCategoria(@PathVariable("id") Long idCategoria) {
        return this.livroService.findByCategoria(idCategoria);
    }

    @GetMapping("/byNome/{nome}")
    public List<Livro> findByNome(@PathVariable("nome") String nome) {
        return this.livroService.findByNome(nome);
    }

    @GetMapping("/byNomeCategoria/{nome}")
    public List<Livro> findByNomeCategoria(@PathVariable("nome") String nomeCategoria) {
        return this.livroService.findByNomeCategoria(nomeCategoria);
    }

    @GetMapping("/comCategorias")
    public List<Livro> findComCategoria() {
        return this.livroService.findComCategorias();
    }

}
