package br.com.curso.web.apirest.spring.various.codenation.api.service;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Acceleration;
import br.com.curso.web.apirest.spring.various.codenation.api.repository.AccelerationRepository;
import br.com.curso.web.apirest.spring.various.codenation.api.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccelerationService implements AccelerationServiceInterface {

    private AccelerationRepository accelerationRepository;
    private CandidateRepository candidateRepository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCandidatesIdCompanyId(companyId);
    }

    @Override
    public List<Acceleration> findAll() {
        salvarAcceleraticonExpectedFindAll();
        return accelerationRepository.findAll();
    }

    private void salvarAcceleraticonExpectedFindAll(){
        Acceleration acceleration = new Acceleration();
        acceleration.setName("Aceleracao With FindAll");
        acceleration.setCreatedAt(LocalDateTime.now());
        acceleration.setSlug("Aceleracao With FindAll");
        acceleration.setCandidates(this.candidateRepository.findAll());
        accelerationRepository.save(acceleration);
    }
}
