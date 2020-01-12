package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.mapper.ApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class SaveToDBService {

    @Inject
    private BookApiConsumer bookApiConsumer;

    @Inject
    private ApiMapper apiMapper;

    @Inject
    private BookDao bookdao;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());


    public void setApi() {
        List<BookJson> bookJsonList = bookApiConsumer.consumeBooks();
        bookJsonList.forEach(b -> {
            Book book = apiMapper.mapApiToEntity(b);
            bookdao.addBook(book);

        });
    }
}
