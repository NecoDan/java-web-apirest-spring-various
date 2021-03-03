package br.com.curso.web.apirest.spring.various.codenation.api.endpoints;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.Challenge;
import br.com.curso.web.apirest.spring.various.codenation.api.service.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/challenge")
@AllArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(
            params = {"accelerationId", "userId"},
            method = RequestMethod.GET
    )
    public List<Challenge> findByAccelerationIdAndUserId(@RequestParam("accelerationId") Long accelerationId,
                                                         @RequestParam("userId") Long userId) {
        return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
