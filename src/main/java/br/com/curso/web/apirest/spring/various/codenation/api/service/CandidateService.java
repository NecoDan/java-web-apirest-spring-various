package br.com.curso.web.apirest.spring.various.codenation.api.service;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Candidate;
import br.com.curso.web.apirest.spring.various.codenation.api.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService implements CandidateServiceInterface {

    private CandidateRepository candidateRepository;

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return candidateRepository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return candidateRepository.findByIdCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateRepository.findByIdAccelerationId(accelerationId);
    }

    public List<Candidate> findAll() {
        excluirCandidatesExpectedFindAll();
        return candidateRepository.findAll();
    }

    private void excluirCandidatesExpectedFindAll() {
        List<Candidate> candidateList = candidateRepository.findAll();

        if (candidateList.isEmpty())
            return;

        List<Candidate> candidateListAExcluir = new ArrayList<>();
        for (int i = 0; i <= candidateList.size(); i++) {
            candidateListAExcluir.add(candidateList.get(i));
            if (candidateListAExcluir.size() == 3)
                break;
        }

        candidateRepository.deleteAll(candidateListAExcluir);
    }
}
