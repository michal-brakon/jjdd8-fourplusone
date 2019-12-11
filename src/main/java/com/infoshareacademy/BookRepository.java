package com.infoshareacademy;

import java.util.List;

public class BookRepository {

    private static BookRepository instance;
    public static List<Book> bookRepository;
    public BookRepository() {
    }
    public List<Book> getBookRepository() {
        return bookRepository;
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

}
