package br.com.curso.web.apirest.spring.various.codenation.biblioteca.service;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Categoria;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Livro;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LivroService implements ILivroService {

    private final LivroRepository livroRepository;
    private final ICategoriaService categoriaService;
    private final IAvaliacaoService avaliacaoService;

    @Override
    public List<Livro> findAll() {
        return this.livroRepository.findAll();
    }

    @Override
    public List<Livro> findByCategoria(Long idCategoria) {
        Categoria categoria = this.categoriaService.findById(idCategoria).get();
        return this.livroRepository.findByCategorias(categoria);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    @Override
    public Livro save(Livro livro) {
        preencherCategorias(livro);
        return this.livroRepository.save(livro);
    }

    @Override
    public void deleteById(Long id) {
        this.livroRepository.deleteById(id);
    }

    @Override
    public List<Livro> findByNome(String nome) {
        return this.livroRepository.findByTituloContaining(nome);
    }

    @Override
    public List<Livro> findByNomeCategoria(String nomeCategoria) {
        // return this.livroRepository.findByNomeCategoria(nomeCategoria);
        return null;
    }

    @Override
    public List<Livro> findComCategorias() {
        return this.livroRepository.findComCategoria();
    }

    private void preencherCategorias(Livro livro) {
        if (livro.getCategorias() != null) {
            List<Categoria> persistedCategorias = new ArrayList<>();
            for (Categoria categoria : livro.getCategorias()) {
                if (categoria.getId() != null) {
                    persistedCategorias.add(this.categoriaService.findById(categoria.getId()).get());
                } else {
                    persistedCategorias.add(this.categoriaService.save(categoria));
                }
            }
            livro.setCategorias(persistedCategorias);
        }
    }
}
