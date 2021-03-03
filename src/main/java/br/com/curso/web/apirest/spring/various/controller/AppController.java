package br.com.curso.web.apirest.spring.various.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @GetMapping("/")
    public String getAppMessage() {
        return appMessage;
    }
}
