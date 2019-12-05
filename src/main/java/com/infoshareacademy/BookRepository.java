package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static ArrayList<Book> bookRepository = Book.book;


    public static ArrayList<Book> getBooks() {
        if (bookRepository == null) {
            System.out.println("Baza jest pusta");
        }
        return bookRepository;
    }
}
