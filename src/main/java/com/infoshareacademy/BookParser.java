package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class BookParser {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void parseJsonFileToObject() {

        try {
            Book.bookList = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    false).readValue(new File("baza.json"), new TypeReference<>() {
            });

        } catch (IOException e) {
            stdout.info("\nNie wczytano bazy z pliku!");
        }
    }
}