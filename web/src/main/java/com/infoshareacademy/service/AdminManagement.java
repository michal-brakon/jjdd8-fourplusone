package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AdminManagement {


    @Inject
    private BookDao bookDao;

    public Long remove(Long id) {
        Book book = bookDao.findById(id);
        return bookDao.delete(book);
    }
}

