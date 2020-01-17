package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.mapper.BookMapper;
import com.infoshareacademy.mapper.view.BookMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class BookService {

    @Inject
    private BookDao bookDao;

    @Inject
    private BookMapperToView bookMapperToView;

    public Book getById(Long id) {
        return this.bookDao.findById(id);
    }



    public List<BookView> findByTitle(String inputParam){
         List<Book> bookList = bookDao.findByTitle(inputParam);
           return bookList.stream()
                   .map(b -> bookMapperToView.mapEntityToView(b))
                   .collect(Collectors.toList());
          }

    @Transactional
    public BookView getBookViewById(Long id) {
        Book book = getById(id);
        return bookMapperToView.mapEntityToView(book);
    }



}
