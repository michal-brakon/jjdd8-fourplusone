package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.mapper.BookMapper;
import com.infoshareacademy.mapper.view.BookMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AdminManagement {

    @Inject
    private BookMapperToView bookMapperToView;
    @Inject
    private BookMapper bookMapper;

    @Inject
    private BookDao bookDao;

    public BookView remove(Long id) {
        return bookMapperToView.mapEntityToView(bookDao.delete(id));
    }

    public void update(Long id, BookDTO bookDTO) {
       Book book = bookDao.findById(id).orElseThrow();
            bookMapper.mapRequestToEntity(bookDTO, book);
            bookDao.update(book);
        }

    public void save(BookDTO bookDTO) {

       Book book  =  bookMapper.mapRequestToEntity(bookDTO);
         bookDao.addBook(book);
    }
}
