package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookParser {

    public static void main(String[] args) {

   new BookParser();
    }
    public BookParser(){

        List<Book> books= new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
try{
        File file = new File("baza.json");
        Book.books= objectMapper.readValue(file, new TypeReference<List<Book>>() {
        });



        System.out.println("");

        System.out.println("Autor ksiażki: " + Book.getBooks());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}