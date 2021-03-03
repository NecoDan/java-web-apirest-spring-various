package br.com.curso.web.apirest.spring.various.codenation.api.endpoints;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Acceleration;
import br.com.curso.web.apirest.spring.various.codenation.api.service.AccelerationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
@AllArgsConstructor
public class AccelerationController {

    private final AccelerationService accelerationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable("id") Long id) {
        return accelerationService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(
            params = {"companhiaId"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Acceleration> findByCompanyId(@RequestParam("companhiaId") Long companhiaId) {
        return accelerationService.findByCompanyId(companhiaId);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(accelerationService.findAll(), HttpStatus.OK);
    }
}
