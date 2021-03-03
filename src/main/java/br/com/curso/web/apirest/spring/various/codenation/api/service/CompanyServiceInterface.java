package br.com.curso.web.apirest.spring.various.codenation.api.service;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Company;
import br.com.curso.web.apirest.spring.various.util.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface CompanyServiceInterface extends ServiceInterface<Company> {

    Optional<Company> findById(Long id);

    List<Company> findByAccelerationId(Long accelerationId);

    List<Company> findByUserId(Long userId);
}
