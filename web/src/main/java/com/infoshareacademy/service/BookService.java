package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.*;
import com.infoshareacademy.dto.BookDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
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

    public void addBooks (List<BookDTO> books)  {

        books
                .forEach(this::addBook);
    }

    public void addBook(BookDTO book) {

        String authorName = book.getAuthor();
        Author author = authorService.findOrAdd(authorName);

        String kindName = book.getKind();
        LiteratureKind kind = kindService.findOrAdd(kindName);

        String epochName = book.getEpoch();
        Epoch epoch = epochService.findOrAdd(epochName);

        String genreName = book.getGenre();
        Genre genre = genreService.findOrAdd(genreName);

        Book bookDaoToEntity = new Book();

        bookDaoToEntity.setAuthor(author);
        bookDaoToEntity.setKind(kind);
        bookDaoToEntity.setEpoch(epoch);
        bookDaoToEntity.setGenre(genre);
        bookDaoToEntity.setTitle(book.getTitle());
        bookDaoToEntity.setCover(book.getCover());
        bookDaoToEntity.setCoverThumb(book.getCoverThumb());
        bookDaoToEntity.setSimpleThumb(book.getSimpleThumb());
        bookDaoToEntity.setHasAudio(book.getHasAudio());

        bookDao.addBook(bookDaoToEntity);
    }
}
