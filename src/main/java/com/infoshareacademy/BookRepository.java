package com.infoshareacademy;

import com.infoshareacademy.bookmanagement.ManageBooks;

import java.util.List;

public class BookRepository {

    private static BookRepository instance;

    private List<Book> books;
    private BookParser bookParser = new BookParser();

    private BookRepository() {
    }

    public List<Book> getBooks() {
        ManageBooks manageBooks = new ManageBooks();
        if (books == null) {
            books = bookParser.loadBooks();
            manageBooks.setId();
            manageBooks.getLastIdNumber();
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
