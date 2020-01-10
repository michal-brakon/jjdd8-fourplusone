package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.Book;
import com.infoshareacademy.service.BookApiConsumer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Stateless
public class KindMapper {

    @Inject
    BookApiConsumer bookApiConsumer;



public void getKing() throws IOException {

    List<Book> book =bookApiConsumer.consumeBooks();




}



}
