package com.infoshareacademy;

import java.util.List;

public class BookRepository {

    private static BookRepository instance;

    private List<Book> books;
    private BookParser bookParser = new BookParser();

    private BookRepository() {
           }

    public List<Book> getBooks() {
            if(books==null){
                books = bookParser.loadBooks();
            }
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
