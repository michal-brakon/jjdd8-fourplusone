package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookRepository {

    private static BookRepository instance;

    private List<Book> books;

    private BookRepository() {
        BookParser bookParser = new BookParser();
        books = bookParser.loadBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

}
