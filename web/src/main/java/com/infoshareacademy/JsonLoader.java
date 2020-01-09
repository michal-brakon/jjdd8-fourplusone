package com.infoshareacademy;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class JsonLoader {


    public void getFromURL () throws IOException {

        List<Book> bookList = List.of();
        ObjectMapper objectMapper = new ObjectMapper();

        URL url = new URL("https://wolnelektury.pl/api/audiobooks/?format=json");

        bookList = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(url, new TypeReference<>() {
                });

        objectMapper.writeValue(new File("json.txt"), bookList);

    }

    public static void main(String[] args) throws IOException {
        new JsonLoader().getFromURL();
    }



}
