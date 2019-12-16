package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;

public class BookAdder {

    public void addBook(String kind, String author, String epoch, String title, boolean hasAudio, String genre) {
        Book book = new Book();
        book.setAuthor(author);
        book.setEpoch(epoch);
        book.setTitle(title);
        book.setHasAudio(hasAudio);
        book.setGenre(genre);
        book.setKind(kind);
        ManageBooks setId = new ManageBooks();
        setId.setId();
        BookRepository.getInstance().getBooks().add(book);

    }
}
