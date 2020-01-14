package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.mapper.view.BookMapper;

import javax.inject.Inject;

public class BookService {

    @Inject
    private BookDao bookDao;

    private BookMapper bookMapper;

    public Book getById(Long id) {
        return this.bookDao.getById(id);
    }

    public String getAuthors(Long id) {
        return bookDao.getBookAuthors(id);
    }


}
