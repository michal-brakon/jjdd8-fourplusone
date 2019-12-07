package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class BookParser {

    private ObjectMapper objectMapper = new ObjectMapper();


    public void parseJsonFileToObject() {

        try {
            Book.book = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    false).readValue(new File("baza.json"), new TypeReference<>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}