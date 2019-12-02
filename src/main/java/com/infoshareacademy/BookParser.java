package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookParser {

    public static void main(String[] args) {


    }
    public BookParser(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            TypeReference<List<Map<String, Book>>> typeReference = new TypeReference<>() {};

            return objectMapper.readValue( typeReference);

            // JSON file to Java object
           // Book book = ObjectMapper.readValue(new File("baza.json"), Book.class);





        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}