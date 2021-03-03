package br.com.curso.web.apirest.spring.various.codenation.biblioteca.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class AvaliacaoIdentity implements Serializable {

    @ManyToOne
    @NotNull
    private Leitor leitor;

    @ManyToOne
    @NotNull
    private Livro livro;
}
