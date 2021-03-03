package br.com.curso.web.apirest.spring.various.codenation.biblioteca.service;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Categoria;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Optional<Categoria> findById(Long id) {
        return this.categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> findAll() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }
}
