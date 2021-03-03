package br.com.curso.web.apirest.spring.various.codenation.biblioteca.service;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    Optional<Categoria> findById(Long id);

    List<Categoria> findAll();

    Categoria save(Categoria categoria);
}
