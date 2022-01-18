package br.com.curso.web.apirest.spring.kamilla_santos_webclient.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonagemResponse {

    private String id;
    private String name;
    private String status;
    private String species;
    private String image;
    private List<String> episode;
}
