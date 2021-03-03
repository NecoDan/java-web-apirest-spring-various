package br.com.curso.web.apirest.spring.various.config;

import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.model.Playlist;
import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class DummyData implements CommandLineRunner {

    private final PlaylistRepository playlistRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Inicializado lançamentos massa de dados...");
//        this.playlistRepository.deleteAll()
//                .thenMany(
//                        Flux.just("API Rest Spring Boot",
//                                "Java 8",
//                                "GitHub",
//                                "Spring Security",
//                                "Web Service RESTFULL",
//                                "Bean no Spring Framework",
//                                "Deploy de uma aplicação java no IBM Cloud")
//                                .map(this::obterPlaylistPor)
//                                .flatMap(playlistRepository::save))
//                .subscribe(System.out::println);
    }

    private Playlist obterPlaylistPor(String nome) {
        return Playlist.builder()
                .id(UUID.randomUUID().toString())
                .nome(nome)
                .build();
    }
}
