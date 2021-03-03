package br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.service;

import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.model.Jedi;
import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.repository.JediRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JediService implements IJediService {

    private final JediRepository jediRepository;

    public Optional<Jedi> findById(Long id) {
        return this.jediRepository.findById(id);
    }

    @Override
    public List<Jedi> findAll() {
        return jediRepository.findAll();
    }

    @Override
    public void salvar(Jedi jedi) {
        jediRepository.save(jedi);
    }
}
