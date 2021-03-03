package br.com.curso.web.apirest.spring.various.codenation.api.service;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.User;
import br.com.curso.web.apirest.spring.various.codenation.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return userRepository.findByCandidatesIdAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return userRepository.findByCandidatesIdCompanyId(companyId);
    }

    @Override
    public UserDetails loadUserByUsername(String loginEmail) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(loginEmail).get();
    }
}
