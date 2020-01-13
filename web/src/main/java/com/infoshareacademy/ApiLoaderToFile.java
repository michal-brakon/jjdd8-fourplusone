package com.infoshareacademy;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ApiLoaderToFile {


    public void getFromURL (String url) throws IOException {

        List<Book> bookList = List.of();
        ObjectMapper objectMapper = new ObjectMapper();



//        bookList = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .readValue(url, new TypeReference<>() {
//                });
 //       System.out.println("ilosc ksiazek: "+bookList.size());

        objectMapper.writeValue(new File("json.txt"), objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(url, new TypeReference<>() {
                }));

    }

    public static void main(String[] args) throws IOException {
        new ApiLoaderToFile().getFromURL("https://wolnelektury.pl/api/books/?format=json");
    }

}
