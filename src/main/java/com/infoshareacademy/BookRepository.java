package com.infoshareacademy;

import java.util.List;

public class BookRepository {

    private BookParser bookParser;

    private static BookRepository instance;
    private static List<Book> bookRepository;

    private BookRepository() {
        bookParser = new BookParser();
    }

    public List<Book> getBookRepository() {
        bookRepository = bookParser.parseJsonFileToObject();
        return bookRepository;
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }


}
