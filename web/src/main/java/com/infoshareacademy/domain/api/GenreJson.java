package com.infoshareacademy.domain.api;

import com.fasterxml.jackson.annotation.JsonInclude;

public class GenreJson {

    @JsonInclude(JsonInclude.Include.NON_NULL)

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
