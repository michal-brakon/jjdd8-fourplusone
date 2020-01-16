package com.infoshareacademy.service;

import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.dto.BookDTO;

import javax.inject.Inject;

public class BookService {

    @Inject
    private AuthorService authorService;

    public void addBook(BookDTO book) {

        String authorName = book.getAuthor();
        Author author = authorService.findOrAdd(authorName);

    }
}
