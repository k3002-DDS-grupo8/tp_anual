package Dominio.ranking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ranking {

    @JsonProperty("id")
    private long id;
    @JsonProperty("detalle")
    private String detalle;

    public long getId() {
        return id;
    }
}
