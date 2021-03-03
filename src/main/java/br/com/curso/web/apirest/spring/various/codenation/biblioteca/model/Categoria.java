package br.com.curso.web.apirest.spring.various.codenation.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String nome;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "LIVRO_CATEGORIA",
            joinColumns = @JoinColumn(name = "idCategoria"),
            inverseJoinColumns = @JoinColumn(name = "idLivro"))
    private List<Livro> livros;
}
