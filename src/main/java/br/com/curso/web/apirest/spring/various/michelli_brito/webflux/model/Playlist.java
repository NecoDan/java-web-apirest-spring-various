package br.com.curso.web.apirest.spring.various.michelli_brito.webflux.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Playlist {
    @Id
    private String id;
    private String nome;
}
