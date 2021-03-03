package br.com.curso.web.apirest.spring.various.algaworks.order_servico.controller;

import br.com.curso.web.apirest.spring.various.util.uteis.RandomicoUtil;
import br.com.curso.web.apirest.spring.various.algaworks.order_servico.model.Cliente;
import br.com.curso.web.apirest.spring.various.algaworks.order_servico.database.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);
        return optionalCliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId))
            return ResponseEntity.notFound().build();

        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId))
            return ResponseEntity.notFound().build();

        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clientesListagem")
    public List<Cliente> listarStatico() {
        return Arrays.asList(
                Cliente.builder()
                        .id(RandomicoUtil.gerarValorRandomicoLong())
                        .nome("Daniel Marcoos")
                        .email("daniel@teste.com.br")
                        .telefone(String.valueOf(RandomicoUtil.gerarValorRandomicoLong()))
                        .build(),
                Cliente.builder()
                        .id(RandomicoUtil.gerarValorRandomicoLong())
                        .nome("Santos")
                        .email("santos@teste.com.br")
                        .telefone(String.valueOf(RandomicoUtil.gerarValorRandomicoLong()))
                        .build(),
                Cliente.builder()
                        .id(RandomicoUtil.gerarValorRandomicoLong())
                        .nome("Gonçalves")
                        .email("gonçalves@teste.com.br")
                        .telefone(String.valueOf(RandomicoUtil.gerarValorRandomicoLong()))
                        .build()
        );
    }
}
