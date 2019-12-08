package com.infoshareacademy;

import java.util.List;

public class BookRepository {

    private List<Book> bookRepository = Book.bookList;


    public List<Book> getBooks() {
        if (bookRepository == null) {
            System.out.println("Baza jest pusta");
        }
        return bookRepository;
    }
}
