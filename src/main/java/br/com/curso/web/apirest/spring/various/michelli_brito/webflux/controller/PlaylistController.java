package br.com.curso.web.apirest.spring.various.michelli_brito.webflux.controller;

import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.model.Playlist;
import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.service.IPlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final IPlaylistService playlistService;

    @GetMapping
    public Flux<Playlist> getAll() {
        return this.playlistService.findAll();
    }

    @GetMapping(value = ("/{id}"))
    public Mono<Playlist> getById(@PathVariable String id) {
        return this.playlistService.findById(id);
    }

    @PostMapping
    public Mono<Playlist> save(@RequestBody Playlist playlist) {
        return this.playlistService.save(playlist);
    }
}
