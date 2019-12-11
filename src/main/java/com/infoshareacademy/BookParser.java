package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookParser {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


    private ObjectMapper objectMapper = new ObjectMapper();


    public List<Book> parseJsonFileToObject() {
        List<Book> parseJson = null;

        try {
            parseJson = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    false).readValue(new File("baza.json"), new TypeReference<>() {
            });
        } catch (IOException e) {
            stdout.info("\nNie wczytano bazy z pliku!");
            new ExceptionMenu().showExceptionMenu();
                   }


        return parseJson;
    }
}