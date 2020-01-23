package com.infoshareacademy.mapper;


import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.dto.BookDTO;

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

    public Book mapRequestToEntity(BookDTO bookDTO, Book book) {


            book.setAuthor(bookDTO.getAuthor());
            book.setTitle(bookDTO.getTitle());
            book.setGenre(bookDTO.getGenre());
            book.setSimpleThumb(bookDTO.getSimpleThumb());
            book.setHasAudio(bookDTO.getHasAudio());
            book.setCoverThumb(bookDTO.getCoverThumb());
            book.setKind(bookDTO.getKind());
            book.setEpoch(bookDTO.getEpoch());

            return book;
        }
    }
}