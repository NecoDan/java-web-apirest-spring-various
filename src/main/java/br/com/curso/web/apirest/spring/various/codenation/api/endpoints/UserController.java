package br.com.curso.web.apirest.spring.various.codenation.api.endpoints;

import br.com.curso.web.apirest.spring.various.codenation.api.entity.User;
import br.com.curso.web.apirest.spring.various.codenation.api.repository.UserRepository;
import br.com.curso.web.apirest.spring.various.codenation.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @RequestMapping(
            params = "accelerationName",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findByAccelerationName(@RequestParam String accelerationName) {
        return new ResponseEntity<>(userService.findByAccelerationName(accelerationName), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(
            params = "companyId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<User> findByCompanyId(@RequestParam("companyId") Long companyId) {
        return userService.findByCompanyId(companyId);
    }

    @GetMapping("/user")
    public List<User> findAll(@RequestParam(required = false) Optional<String> accelerationName,
                              @RequestParam(required = false) Optional<Long> companyId) {
        return accelerationName.map(userService::findByAccelerationName)
                .orElseGet(() -> companyId.map(userService::findByCompanyId).orElse(new ArrayList<>()));
    }

    @GetMapping("/user/exibirTodos")
    public List<User> listarTodos() {
        return userRepository.findAll();
    }

}
