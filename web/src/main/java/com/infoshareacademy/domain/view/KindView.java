package com.infoshareacademy.domain.view;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class KindView {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
