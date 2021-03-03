package br.com.curso.web.apirest.spring.various.codenation.biblioteca.repository;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Avaliacao;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.AvaliacaoIdentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, AvaliacaoIdentity> {
    List<Avaliacao> findAll();
}
