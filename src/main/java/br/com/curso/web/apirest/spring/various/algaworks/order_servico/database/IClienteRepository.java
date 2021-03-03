package br.com.curso.web.apirest.spring.various.algaworks.order_servico.database;

import br.com.curso.web.apirest.spring.various.algaworks.order_servico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findClienteByNome(String nome);

    List<Cliente> findAllClienteByNome(String nome);

    List<Cliente> findByNomeContaining(String descricao);
}
