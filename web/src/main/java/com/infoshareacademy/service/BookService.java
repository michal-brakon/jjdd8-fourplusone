package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.mapper.BookMapper;

import javax.inject.Inject;

public class BookService {

    @Inject
    private BookDao bookDao;

    @Inject
    private BookMapper bookMapper;


    public Book getById(Long id) {return this.bookDao.getById(id);}

}
