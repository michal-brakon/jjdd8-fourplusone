package com.infoshareacademy.Language;

public enum LanguagesToChoose {
    PL("messages_pl"),
    ENG("messages");

    private String value;

    LanguagesToChoose(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
