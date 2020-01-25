package com.infoshareacademy.mapper;


import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.dto.BookDTO;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookMapper {

    public Book mapRequestToEntity(BookDTO bookDTO, Book book) {


        book.setTitle(bookDTO.getTitle());
        book.setSimpleThumb(bookDTO.getSimpleThumb());
        book.setHasAudio(bookDTO.getHasAudio());
        book.setCoverThumb(bookDTO.getCoverThumb());

        return book;
    }
}
