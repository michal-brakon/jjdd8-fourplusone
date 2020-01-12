package com.infoshareacademy.mapper;


import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.*;

import javax.ejb.Stateless;
import java.util.Set;

@Stateless
public class ApiMapper {


    public Book mapApiToEntity(BookJson books) {


        Book book = new Book();
        Author author = new Author();
        LiteratureKind kind = new LiteratureKind();
        Genre genre = new Genre();
        Epoch epoch = new Epoch();
        book.setTitle(books.getTitle());
        book.setCover(books.getCover());
        book.setCoverThumb(books.getCoverThumb());
        book.setHasAudio(books.getHasAudio());
        book.setSimpleThumb(books.getSimpleThumb());
        author.setName(books.getAuthor());
        genre.setName(books.getGenre());
        kind.setName(books.getKind());
        epoch.setName(books.getEpoch());
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(genre));

        return book;

    }


}
