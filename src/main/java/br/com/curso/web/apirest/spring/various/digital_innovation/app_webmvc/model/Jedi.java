package br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "jedis")
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 10, message = "Nome deve conter entre 3 e 10 caracteres.")
    @NotNull
    @NotBlank(message = "Insira um nome válido")
    @Column(name = "nome")
    private String nome;

    @NotNull
    @NotBlank(message = "Insira um sobrenome válido")
    @Column(name = "sobrenome")
    private String sobrenome;
}
