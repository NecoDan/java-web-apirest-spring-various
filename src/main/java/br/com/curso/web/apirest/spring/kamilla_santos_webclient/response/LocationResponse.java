package br.com.curso.web.apirest.spring.kamilla_santos_webclient.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LocationResponse {

    private String id;
    private String name;
    private String type;
    private List<String> residents;
    private String url;
}
