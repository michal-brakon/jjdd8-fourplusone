package com.infoshareacademy;


import java.util.List;

public class BookRepository {

    private static List<Book> bookRepository = Book.book;


    public static List<Book> getBooks() {
        if (bookRepository == null) {
            System.out.println("Baza jest pusta");
        }
        return bookRepository;
    }
}
