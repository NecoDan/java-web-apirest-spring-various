package br.com.curso.web.apirest.spring.various.michelli_brito.webflux.controller.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PlaylistRouter {

    private static final String URI = "/v1/playlists";

    @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandler handler) {
        return RouterFunctions
                .route(GET(URI)
                        .and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET(URI + "/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST(URI)
                        .and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
