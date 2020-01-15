package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.mapper.ApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;

@Startup
@Singleton
public class ApiDataInitializer {

    @Inject
    private BookApiConsumer bookApiConsumer;

    @Inject
    private ApiMapper apiMapper;

    @Inject
    private BookDao bookDao;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PostConstruct
    public void setApi() {
        List<BookJson> bookJsonList = bookApiConsumer.consumeBooks();
        bookJsonList.forEach(b -> {
            Book book = apiMapper.mapApiToEntity(b);
            bookDao.addBook(book);

        });
    }
}
