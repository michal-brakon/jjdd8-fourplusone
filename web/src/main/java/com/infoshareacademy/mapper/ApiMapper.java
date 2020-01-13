package com.infoshareacademy.mapper;


import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;

@Stateless
public class ApiMapper {

    @Inject
    private AuthorMapper authorMapper;


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
