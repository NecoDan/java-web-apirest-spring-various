package br.com.curso.web.apirest.spring.various.codenation.api.service;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Submission;
import br.com.curso.web.apirest.spring.various.util.ServiceInterface;

import java.util.List;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}
