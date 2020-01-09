package com.infoshareacademy.service;

import com.infoshareacademy.dao.SingleBookDao;
import com.infoshareacademy.mapper.SingleBookMapper;

import javax.inject.Inject;

public class SingleBookService {

    @Inject
    private SingleBookDao singleBookDao;

    @Inject
    private SingleBookMapper singleBookMapper;

}
