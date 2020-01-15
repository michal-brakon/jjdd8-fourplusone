package com.infoshareacademy.domain.view;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.service.BookService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AuthorView {

    @Inject
    private BookService bookService;

    @Inject private BookDao bookDao;

    Long authorID = bookDao.getBookAuthors()

    String name = bookDao.getBookAuthors();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}