package br.com.curso.web.apirest.spring.kamilla_santos_webclient.client;

import br.com.curso.web.apirest.spring.kamilla_santos_webclient.response.PersonagemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RickyAndMortyClient {

    private final WebClient webClient;
    private static final String URL = "https://rickandmortyapi.com/api";

    public RickyAndMortyClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(URL).build();
    }

    public Mono<PersonagemResponse> buscarPersonagemPorId(String id) {

        log.info("efetuando a busca por um personagem pelo id { {} }", id);
        return webClient.get()
                .uri("/character/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(PersonagemResponse.class);
    }
}
