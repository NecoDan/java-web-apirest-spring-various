package br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.repository;

import br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
}
