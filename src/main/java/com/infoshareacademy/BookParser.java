package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new BookParser();
        System.out.println("podaj rodzaj ksiażki: ");
        String searchOfKind = scanner.nextLine();
        for (int i = 0; i < ExternalBook.externalBooks.size(); i++) {

            ExternalBook record = ExternalBook.externalBooks.get(i);
            if (record.getAuthor().contains(searchOfKind))
                System.out.println(record.getKind() + "\n" + record.getUrl() + "\n" + record.getAuthor());

        }
    }

}