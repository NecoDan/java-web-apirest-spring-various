package br.com.curso.web.apirest.spring.various.codenation.biblioteca.service;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Livro;

import java.util.List;
import java.util.Optional;

public interface ILivroService {

    List<Livro> findAll();

    List<Livro> findByCategoria(Long idCategoria);

    Optional<Livro> findById(Long id);

    Livro save(Livro livro);

    void deleteById(Long id);

    List<Livro> findByNome(String nome);

    List<Livro> findByNomeCategoria(String nomeCategoria);

    List<Livro> findComCategorias();
}
