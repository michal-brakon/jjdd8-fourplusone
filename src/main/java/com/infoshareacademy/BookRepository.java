package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public static List<Book> bookRepository = new ArrayList<>();


    public static void getBooks() {
        if (bookRepository == null) {
            System.out.println("Baza jest pusta");
        }
    }
}
