package br.com.curso.web.apirest.spring.kamilla_santos_webclient.controller;

import br.com.curso.web.apirest.spring.kamilla_santos_webclient.client.RickyAndMortyClient;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.EpisodioListResponse;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.EpisodioResponse;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.LocationResponse;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.PersonagemResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/webclient/rickandmorty")
public class RickyAndMortyController {

    private RickyAndMortyClient rickyAndMortyClient;

    @GetMapping("/personagens/{id}")
    public Mono<PersonagemResponse> buscarPersonagemPorId(@PathVariable("id") String id) {
        return this.rickyAndMortyClient.buscarPersonagemPorId(id);
    }

    @GetMapping("/planetas/{id}")
    public Mono<LocationResponse> buscarLocalizacaoPlanetaPorId(@PathVariable("id") String id) {
        return this.rickyAndMortyClient.buscarLocalizacaoPorId(id);
    }

    @GetMapping("/episodios/{id}")
    public Mono<EpisodioResponse> buscarEpisodioPorId(@PathVariable("id") String id) {
        return this.rickyAndMortyClient.buscarEpisodioPorId(id);
    }

    @GetMapping("/episodios")
    public Flux<EpisodioListResponse> buscarTodosEpisodios() {
        return this.rickyAndMortyClient.buscarTodosEpisodios();
    }
}
