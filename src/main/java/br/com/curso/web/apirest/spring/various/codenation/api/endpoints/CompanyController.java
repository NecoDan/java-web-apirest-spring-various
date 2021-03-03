package br.com.curso.web.apirest.spring.various.codenation.api.endpoints;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Company;
import br.com.curso.web.apirest.spring.various.codenation.api.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @RequestMapping(
            params = "accelerationId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Company> findByAccelerationId(@RequestParam("accelerationId") Long id) {
        return companyService.findByAccelerationId(id);
    }

    @RequestMapping(
            params = "userId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Company> findByUserId(@RequestParam("userId") Long id) {
        return companyService.findByUserId(id);
    }
}
