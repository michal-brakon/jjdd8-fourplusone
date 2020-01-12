package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.mapper.BookMapper;

import javax.inject.Inject;
import javax.swing.text.View;

public class BookService {

    @Inject
    private BookDao bookDao;

    private BookMapper bookMapper;

    public Book getById(Long id) {
        return this.bookDao.getById(id);
    }

    public View getView(Long id) {
        return bookMapper.mapEntityToView(id);
    }


}
