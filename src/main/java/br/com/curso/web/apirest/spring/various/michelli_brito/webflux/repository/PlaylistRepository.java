package br.com.curso.web.apirest.spring.various.michelli_brito.webflux.repository;

import br.com.curso.web.apirest.spring.various.michelli_brito.webflux.model.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
