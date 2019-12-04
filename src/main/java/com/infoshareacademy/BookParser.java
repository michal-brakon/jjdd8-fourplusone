package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class BookParser {



    public BookParser() {


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("baza.json");
            ExternalBook.externalBooks = objectMapper.readValue(file, new TypeReference<>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}