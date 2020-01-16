package com.infoshareacademy.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreJson {

    @JsonProperty("genre")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
