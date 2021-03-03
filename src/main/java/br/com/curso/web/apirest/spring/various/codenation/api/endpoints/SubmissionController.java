package br.com.curso.web.apirest.spring.various.codenation.api.endpoints;

import br.com.curso.web.apirest.spring.various.codenation.api.dto.SubmissionDTO;
import br.com.curso.web.apirest.spring.various.codenation.api.mappers.SubmissionMapper;
import br.com.curso.web.apirest.spring.various.codenation.api.service.SubmissionServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/submission")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionServiceInterface submissionService;
    private final SubmissionMapper mapper;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(
            params = {"challengeId", "accelerationId"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam("challengeId") Long challengeId, @RequestParam("accelerationId") Long accelerationId) {
        return mapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }
}
