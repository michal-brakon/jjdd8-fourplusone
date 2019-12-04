package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public static List<Book> bookRepository = new ArrayList<>();


    public static List<Book> getBooks() {
        if (bookRepository == null) {
            System.out.println("Baza jest pusta");
        }
        return bookRepository;
    }
}
