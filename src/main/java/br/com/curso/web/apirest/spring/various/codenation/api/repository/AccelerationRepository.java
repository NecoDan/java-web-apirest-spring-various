package br.com.curso.web.apirest.spring.various.codenation.api.repository;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {
    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);
}
