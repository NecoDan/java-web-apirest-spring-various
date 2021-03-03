package br.com.curso.web.apirest.spring.various.michelli_brito.webflux.controller;

import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.model.Playlist;
import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.service.IPlaylistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequestMapping("/v1/playlists/events")
@Slf4j
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

    @GetMapping(value = "/generate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));

        Flux<Playlist> events = playlistService.findAll();
        log.info("Stream de eventos em execucao...");
        return Flux.zip(interval, events);
    }
}
