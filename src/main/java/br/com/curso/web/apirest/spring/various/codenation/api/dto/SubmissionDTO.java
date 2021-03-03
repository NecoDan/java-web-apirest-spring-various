package br.com.curso.web.apirest.spring.various.codenation.api.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDTO {
    private Long challengeId;
    private String userId;
    private BigDecimal score;
    private String createdAt;
}
