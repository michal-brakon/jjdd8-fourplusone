package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PaginationService {

    @Inject
    BookDao bookDao;

    public int add(int num) {
        return num + 20;
    }

    public int reduce(int num) {
        return num - 20;
    }

    public int numOfRecords(int num) {

        return bookDao.getNumberOfRecords() - 20;
    }
}
