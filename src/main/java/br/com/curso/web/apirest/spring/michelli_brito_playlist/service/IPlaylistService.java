package br.com.curso.web.apirest.spring.michelli_brito_playlist.service;

import br.com.curso.web.apirest.spring.michelli_brito_playlist.model.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPlaylistService {

    Flux<Playlist> findAll();

    Mono<Playlist> findById(String id);

    Mono<Playlist> save(Playlist playlist);

}
