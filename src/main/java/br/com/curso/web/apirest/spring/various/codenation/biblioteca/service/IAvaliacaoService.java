package br.com.curso.web.apirest.spring.various.codenation.biblioteca.service;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Avaliacao;

import java.util.List;

public interface IAvaliacaoService {

    List<Avaliacao> findAll();

    Avaliacao save(Avaliacao avaliacao);
}
