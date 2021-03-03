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

    private final FuncionarioRepository funcionarioRepository;

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
        Funcionario funcionarioChefe = this.funcionarioRepository
                .findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException(("Funcionario chefe inexistente.")));

        funcionario.setChefe(funcionarioChefe);
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> recuperarFuncionariosPorIdade(Integer de, Integer ate) {
        return this.funcionarioRepository.recuperarFuncionariosPorIdade(de, ate);
    }

    @Override
    public List<Funcionario> recuperarFuncionariosPorNome(String nome) {
        return this.funcionarioRepository.findByNome(nome);
    }
}
