package br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.repository;

import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {
    List<Jedi> findByNomeContaining(final String nome);
}
