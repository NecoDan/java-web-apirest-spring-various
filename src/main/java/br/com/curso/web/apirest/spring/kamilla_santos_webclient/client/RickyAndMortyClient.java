package br.com.curso.web.apirest.spring.kamilla_santos_webclient.client;

import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.EpisodioListResponse;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.EpisodioResponse;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.LocationResponse;
import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.PersonagemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RickyAndMortyClient {

    private final WebClient webClient;
    private static final String URL = "https://rickandmortyapi.com/api/";

    public RickyAndMortyClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(URL).build();
    }

    public Mono<PersonagemResponse> buscarPersonagemPorId(String id) {

        log.info("efetuando a busca por um personagem pelo id {{}}", id);
        return webClient.get()
                .uri("/character/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(PersonagemResponse.class);
    }

    public Mono<LocationResponse> buscarLocalizacaoPorId(String id) {

        log.info("efetuando a busca de uma localização e/ou planeta pelo id {{}}", id);
        return webClient.get()
                .uri("/location/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodioResponse> buscarEpisodioPorId(String id) {

        log.info("efetuando a busca de um episódio por id {{}}", id);
        return webClient.get()
                .uri("/episode/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(EpisodioResponse.class);
    }

    public Flux<EpisodioListResponse> buscarTodosEpisodios() {

        log.info("efetuando a busca de todos os episódios");
        return webClient.get()
                .uri("/episode/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Erro ao efetuar a busca de todos os episódios")))
                .bodyToFlux(EpisodioListResponse.class);
    }
}
