package br.com.curso.web.apirest.spring.various.codenation.biblioteca.service;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Avaliacao;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AvaliacaoService implements IAvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public List<Avaliacao> findAll() {
        return this.avaliacaoRepository.findAll();
    }

    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        return this.avaliacaoRepository.save(avaliacao);
    }

}
