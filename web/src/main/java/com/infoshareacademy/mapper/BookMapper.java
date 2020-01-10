package com.infoshareacademy.mapper;


import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.service.ParserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@Stateless
public class BookMapper {

    @Inject
    private ParserService parserService;

    @Inject
    private AuthorDao authorDao;

    public Book mapApiToEntity(BookJson books) {

        Book book = new Book();
        book.setTitle(books.getTitle());
        book.setCover(books.getCover());
        book.setCoverThumb(books.getCoverThumb());
        book.setHasAudio(books.getHasAudio());
        book.setSimpleThumb(books.getSimpleThumb());
        authorDao.setAuthors(books.getAuthor());

        List<Author > authorSet = Arrays.asList(books.getAutho);

        return book;

    }


}
