package com.infoshareacademy.service;

import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.entity.Genre;
import com.infoshareacademy.domain.entity.LiteratureKind;
import com.infoshareacademy.dto.BookDTO;

import javax.inject.Inject;

public class BookService {

    @Inject
    private AuthorService authorService;

    @Inject
    private KindService kindService;

    @Inject
    private EpochService epochService;

    @Inject
    private GenreService genreService;

    public void addBook(BookDTO book) {

        String authorName = book.getAuthor();
        Author author = authorService.findOrAdd(authorName);

        String kindName = book.getKind();
        LiteratureKind kind = kindService.findOrAdd(kindName);

        String epochName = book.getEpoch();
        Epoch epoch = epochService.findOrAdd(epochName);

        String genreName = book.getGenre();
        Genre genre = genreService.findOrAdd(genreName);

    }
}
