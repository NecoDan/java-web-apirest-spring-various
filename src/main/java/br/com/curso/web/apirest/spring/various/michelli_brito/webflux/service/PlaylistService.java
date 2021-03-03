package br.com.curso.web.apirest.spring.various.michelli_brito.webflux.service;

import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.model.Playlist;
import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaylistService implements IPlaylistService {

    private final PlaylistRepository playlistRepository;

    @Override
    public Flux<Playlist> findAll() {
        return this.playlistRepository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return this.playlistRepository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return this.playlistRepository.save(playlist);
    }
}
