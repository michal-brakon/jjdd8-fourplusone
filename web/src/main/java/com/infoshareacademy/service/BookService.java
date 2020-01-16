package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.mapper.view.BookMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
public class BookService {

    @Inject
    private BookDao bookDao;

    @Inject
    private BookMapperToView bookMapperToView;

    public Book getById(Long id) {
        return this.bookDao.findById(id);
    }

    //public String getAuthors(Long id) {
 //       return bookDao.getBookAuthors(id);
 //   }

    @Transactional
    public BookView getBookViewById(Long id) {
        Book book = getById(id);
        return bookMapperToView.mapEntityToView(book);
    }


}
