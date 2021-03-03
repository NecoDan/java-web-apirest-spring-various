package br.com.curso.web.apirest.spring.various.codenation.api.service;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Candidate;
import br.com.curso.web.apirest.spring.various.util.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface CandidateServiceInterface extends ServiceInterface<Candidate> {

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);
}
