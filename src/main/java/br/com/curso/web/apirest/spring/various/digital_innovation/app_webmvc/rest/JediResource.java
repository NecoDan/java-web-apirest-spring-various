package br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.rest;

import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.model.Jedi;
import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.service.JediService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/api/jedis")
@RequiredArgsConstructor
public class JediResource {

    private final JediService jediService;

    @GetMapping
    public List<Jedi> getAllJedi() {
        return this.jediService.findAll();
    }

    @GetMapping("/{id}")
    public Jedi getJedi(@PathVariable Long id) {
        // Optional<Jedi> jedi = this.jediService.findById(id);
        return null;
    }
}
