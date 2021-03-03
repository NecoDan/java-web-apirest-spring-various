package br.com.curso.web.apirest.spring.various.codenation.api.service;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Acceleration;
import br.com.curso.web.apirest.spring.various.util.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    List<Acceleration> findAll();

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId);
}
