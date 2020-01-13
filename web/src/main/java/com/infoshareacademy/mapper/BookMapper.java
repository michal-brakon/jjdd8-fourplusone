package com.infoshareacademy.mapper;


import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.domain.api.AuthorJson;
import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.entity.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;

@Stateless
public class BookMapper {

    @Inject
    private AuthorJson authorJson;

    @Inject
    private AuthorDao authorDao;

    public Book mapApiToEntity(BookJson bookJson) {

        Book book = new Book();
        book.setTitle(bookJson.getTitle());
        book.setCover(bookJson.getCover());
        book.setCoverThumb(bookJson.getCoverThumb());
        book.setHasAudio(bookJson.getHasAudio());
        book.setSimpleThumb(bookJson.getSimpleThumb());

        if (authorJson.getName().equals(bookJson.getAuthor())){
           authorDao.findAuthorByName(bookJson.getAuthor());
            book.setAuthors();
        }

        return book;
    }
}
