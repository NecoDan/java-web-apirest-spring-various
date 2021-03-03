package br.com.curso.web.apirest.spring.various.util.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class CustomErrorType {
    private String erroMensagem;
}
