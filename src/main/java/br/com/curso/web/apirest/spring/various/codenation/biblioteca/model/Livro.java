package br.com.curso.web.apirest.spring.various.codenation.biblioteca.model;

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
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String titulo;

    @OneToMany
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    @JoinTable(name="LIVRO_CATEGORIA",
            joinColumns=@JoinColumn(name="idLivro"),
            inverseJoinColumns=@JoinColumn(name="idCategoria"))
    private List<Categoria> categorias;
}
