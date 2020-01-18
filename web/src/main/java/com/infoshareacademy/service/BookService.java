package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.mapper.view.BookMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class BookService {

    @Inject
    private BookDao bookDao;

    @Inject
    private BookMapperToView bookMapperToView;

    public Book getById(Long id) {
        return this.bookDao.findById(id);
    }

    @Transactional
    public BookView getBookViewById(Long id) {
        Book book = getById(id);
        return bookMapperToView.mapEntityToView(book);
    }

    @Transactional
    public List<BookView> getAllBooksView() {
        List<Book> bookViews = bookDao.findAll();
        return bookViews.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<BookView> booksForPagination() {

        List<Book> booksPagination = bookDao.getBooksForPagination();
        return booksPagination.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }
}
