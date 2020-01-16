package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.*;
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

    @Inject
    private BookDao bookDao;

    public void addBook(BookDTO book) {

        String authorName = book.getAuthor();
        Author author = authorService.findOrAdd(authorName);

        String kindName = book.getKind();
        LiteratureKind kind = kindService.findOrAdd(kindName);

        String epochName = book.getEpoch();
        Epoch epoch = epochService.findOrAdd(epochName);

        String genreName = book.getGenre();
        Genre genre = genreService.findOrAdd(genreName);

        Book bookToDao = new Book();
        bookToDao.setAuthor(author);
        bookToDao.setKind(kind);
        bookToDao.setEpoch(epoch);
        bookToDao.setGenre(genre);
        bookToDao.setCover(book.getCover());
        bookToDao.setCoverThumb(book.getCoverThumb());
        bookToDao.setSimpleThumb(book.getSimple_thumb());
        bookToDao.setHasAudio(book.getHasAudio());

        bookDao.addBook(bookToDao);


    }
}
