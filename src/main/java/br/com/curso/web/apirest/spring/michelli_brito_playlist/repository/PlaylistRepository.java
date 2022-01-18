package br.com.curso.web.apirest.spring.michelli_brito_playlist.repository;

import br.com.curso.web.apirest.spring.michelli_brito_playlist.model.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
