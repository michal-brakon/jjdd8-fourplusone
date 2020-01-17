package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.mapper.view.BookMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<BookView> getAllBooks() {
        List<BookView> list = developerDao.find();


        return JsonHelper.toArray(devs.stream()
                .map(d -> devMapper.toShortJson(d))
                .toArray());


}
