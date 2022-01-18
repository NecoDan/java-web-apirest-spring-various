package br.com.curso.web.apirest.spring.kamilla_santos_webclient.controller;

import br.com.curso.web.apirest.spring.kamilla_santos_webclient.client.RickyAndMortyClient;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.PersonagemResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Slf4j
@Controller
@RequestMapping("/webclient")
public class RickyAndMortyController {

    private RickyAndMortyClient rickyAndMortyClient;

    @GetMapping("/personagens/{id}")
    public Mono<PersonagemResponse> buscarPersonagemPorId(@PathVariable("id") String id) {
        return this.rickyAndMortyClient.buscarPersonagemPorId(id);
    }

}
