package br.com.curso.web.apirest.spring.various.codenation.api.endpoints;

import br.com.curso.web.apirest.spring.various.codenation.api.dto.CandidateDTO;
import br.com.curso.web.apirest.spring.various.codenation.api.entity.Candidate;
import br.com.curso.web.apirest.spring.various.codenation.api.mappers.CandidateMapper;
import br.com.curso.web.apirest.spring.various.codenation.api.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateMapper mapper;

    @GetMapping("/{userId}/{accelerationId}/{companhiaId}")
    public Optional<Candidate> findById(@PathVariable("userId") Long userId, @PathVariable("companhiaId") Long companhiaId,
                                        @PathVariable("accelerationId") Long accelerationId) {
        return candidateService.findById(userId, companhiaId, accelerationId);
    }

    @RequestMapping(
            params = "companhiaId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CandidateDTO> findByCompanyId(@RequestParam("companhiaId") Long companhiaId) {
        return mapper.map(candidateService.findByCompanyId(companhiaId));
    }

    @RequestMapping(
            params = "accelerationId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CandidateDTO> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId) {
        return mapper.map(candidateService.findByAccelerationId(accelerationId));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(candidateService.findAll(), HttpStatus.OK);
    }
}
