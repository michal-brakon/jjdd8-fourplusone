package com.infoshareacademy.mapper;


import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Book;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookMapper {

    public Book mapApiToEntity(BookJson bookJson) {

        Book book = new Book();
        book.setTitle(bookJson.getTitle());
        book.setCover(bookJson.getCover());
        book.setCoverThumb(bookJson.getCoverThumb());
        book.setHasAudio(bookJson.getHasAudio());
        book.setSimpleThumb(bookJson.getSimpleThumb());

        return book;
    }
}
