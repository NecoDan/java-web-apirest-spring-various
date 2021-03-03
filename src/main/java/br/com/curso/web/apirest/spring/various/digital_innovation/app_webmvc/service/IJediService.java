package br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.service;

import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.model.Jedi;

import java.util.List;
import java.util.Optional;

public interface IJediService {

    Optional<Jedi> findById(Long id);

    List<Jedi> findAll();

    void salvar(Jedi jedi);
}
