package br.com.curso.web.apirest.spring.kamilla_santos_webclient.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EpisodioResponse {

    private String id;

    private String name;

    @JsonProperty("air_date")
    private String airDate;

    private String episode;

    private List<String> characters;

    private String url;
}
