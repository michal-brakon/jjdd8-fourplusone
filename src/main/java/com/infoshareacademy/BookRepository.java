package com.infoshareacademy;

import java.util.List;

public class BookRepository {

    private static BookRepository instance;

    private List<Book> books;
    private BookParser bookParser = new BookParser();

    private BookRepository() {
    }

    public List<Book> getBooks() {
        if (books == null) {
            books = bookParser.loadBooks();
        }
        return books;
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }
}
