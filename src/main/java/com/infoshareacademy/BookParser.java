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
import java.util.Scanner;

public class BookParser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new BookParser();
        System.out.println("podaj Autora: ");
        String searchOfKind = scanner.nextLine();
        for (int i = 0; i < Book.books.size(); i++) {

            Book record = Book.books.get(i);


            if (record.getAuthor().contains(searchOfKind))
                System.out.println(record.getKind() + "\n" + record.getUrl() + "\n" + record.getAuthor());

        }
    }

    public BookParser() {


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("baza.json");
            Book.books = objectMapper.readValue(file, new TypeReference<List<Book>>() {
            });
            //  System.out.println(Book.getBooks());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}