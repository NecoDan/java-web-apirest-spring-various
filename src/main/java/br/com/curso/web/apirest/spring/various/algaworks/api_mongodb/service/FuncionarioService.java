package br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.service;

import br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.model.Funcionario;
import br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements IFuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> buscarTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Optional<Funcionario> buscarPorId(String codigo) {
        return this.funcionarioRepository.findById(codigo);
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return this.funcionarioRepository.save(funcionario);
    }
}
