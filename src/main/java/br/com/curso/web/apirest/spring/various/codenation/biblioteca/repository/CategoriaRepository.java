package br.com.curso.web.apirest.spring.various.codenation.biblioteca.repository;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findAll();
}
