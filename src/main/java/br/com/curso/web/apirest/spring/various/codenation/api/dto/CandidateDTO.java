package br.com.curso.web.apirest.spring.various.codenation.api.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {
    private Long userId;
    private Long accelerationId;
    private Long companyId;
    private Integer status;
    private String createdAt;
}
