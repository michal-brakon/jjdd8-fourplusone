package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.*;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.mapper.BookMapper;
import com.infoshareacademy.mapper.view.BookMapperToView;
import com.infoshareacademy.service.email.MailSender;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AdminManagement {

    @Inject
    private BookMapperToView bookMapperToView;

    @Inject
    private BookMapper bookMapper;

    @Inject
    private BookService bookService;

    @Inject
    private BookDao bookDao;

    @Inject
    private AuthorService authorService;

    @Inject
    private KindService kindService;

    @Inject
    private EpochService epochService;

    @Inject
    private GenreService genreService;

    @Inject
    private MailSender mailSender;


    public BookView remove(Long id) {
        return bookMapperToView.mapEntityToView(bookDao.delete(id));
    }

    public void update(Long id, BookDTO bookDTO) {
        Book book = bookDao.findById(id).orElseThrow();
        bookMapper.mapRequestToEntity(bookDTO, book);

        Author author = authorService.findOrAdd(bookDTO.getAuthor());
        book.setAuthor(author);
        Genre genre = genreService.findOrAdd(bookDTO.getGenre());
        book.setGenre(genre);
        LiteratureKind kind = kindService.findOrAdd(bookDTO.getKind());
        book.setKind(kind);
        Epoch epoch = epochService.findOrAdd(bookDTO.getEpoch());
        book.setEpoch(epoch);
        bookDao.update(book);
    }

    public void save(BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }

    public List<BookView> findAll() {
        List<BookView> bookViews = new ArrayList<>();
        bookDao.findAll().forEach(book -> {
            BookView bookView = bookMapperToView.mapEntityToView(book);
            bookViews.add(bookView);
        });
        return bookViews;
    }
}