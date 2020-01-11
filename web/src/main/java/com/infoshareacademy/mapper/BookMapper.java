package com.infoshareacademy.mapper;


import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.entity.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookMapper {

    @Inject
    private AuthorDao authorDao;

    public Book mapApiToEntity(BookJson books) {

        Author author = new Author();
        Book book = new Book();
        book.setTitle(books.getTitle());
        book.setCover(books.getCover());
        book.setCoverThumb(books.getCoverThumb());
        book.setHasAudio(books.getHasAudio());
        book.setSimpleThumb(books.getSimpleThumb());
        author.setName(books.getAuthor());
        authorDao.setAuthor(author);

        return book;

    }


}
