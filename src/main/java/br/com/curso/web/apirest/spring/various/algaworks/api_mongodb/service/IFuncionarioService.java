package br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.service;

import br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface IFuncionarioService {

    List<Funcionario> buscarTodos();

    Optional<Funcionario> buscarPorId(String codigo);

    Funcionario salvar(Funcionario funcionario);

}
