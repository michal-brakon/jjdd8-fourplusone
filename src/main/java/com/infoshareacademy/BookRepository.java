package com.infoshareacademy;

import java.util.List;

public class BookRepository {

    private BookParser bookParser;

    private static BookRepository instance;

    private BookRepository() {
        bookParser = new BookParser();
    }

    public List<Book> getBookRepository() {
        return bookParser.parseJsonFileToObject();
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

}
