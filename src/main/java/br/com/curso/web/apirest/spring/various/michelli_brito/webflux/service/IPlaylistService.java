package br.com.curso.web.apirest.spring.various.michelli_brito.webflux.service;

import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.model.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPlaylistService {

    Flux<Playlist> findAll();

    Mono<Playlist> findById(String id);

    Mono<Playlist> save(Playlist playlist);

}
