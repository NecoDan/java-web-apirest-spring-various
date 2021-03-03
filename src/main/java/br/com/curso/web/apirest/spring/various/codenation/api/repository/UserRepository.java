package br.com.curso.web.apirest.spring.various.codenation.api.repository;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByCandidatesIdAccelerationName(String name);

    List<User> findByCandidatesIdCompanyId(Long companyId);

    Optional<User> findByEmail(String email);

    User findByNickname(String nickNameLogin);
}
