package br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.repository;

import br.com.curso.web.apirest.spring.various.algaworks.api_mongodb.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    @Query("{ $and: [ { 'idade': {$gte: ?0 } },  { 'idade': {$lte: ?1 } }  ] }")
    List<Funcionario> recuperarFuncionariosPorIdade(Integer de, Integer ate);

    List<Funcionario> findByNome(String nome);

}
