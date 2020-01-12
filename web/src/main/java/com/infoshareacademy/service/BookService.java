package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.entity.Book;
import com.infoshareacademy.mapper.BookMapper;

import javax.inject.Inject;
import javax.swing.text.ComponentView;

public class BookService {

    @Inject
    private BookDao bookDao;

    public Book getById(Long id) {return this.bookDao.getById(id);}



}
