package com.infoshareacademy.service;

import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.api.AuthorJson;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.mapper.ApiMapper;
import com.infoshareacademy.mapper.AuthorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.List;

@Startup
@Singleton
public class ApiDataInitializer {

    @Inject
    private BookApiConsumer bookApiConsumer;

    @Inject
    private ApiMapper apiMapper;

    @Inject
    private AuthorMapper authorMapper;

    @Inject
    private BookDao bookdao;

    @Inject
    private AuthorDao authorDao;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private static final String URI = "http://isa-proxy.blueazurit.com/books/books/";
    private static final String AUTHOR_URI = "http://isa-proxy.blueazurit.com/books/authors/";


    @PostConstruct
    public void setApi() {

        List<AuthorJson> bookJsonList = bookApiConsumer.consume(getAuthorClientTarget(), AuthorJson.class);
        bookJsonList.forEach(b -> {
            Author author = authorMapper.mapApiRequestToEntity(b.getName());
            authorDao.addAuthor(author);

        });
//        List<BookJson> bookJsonList = bookApiConsumer.consume(getBookClientTarget(), BookJson.class);
//        bookJsonList.forEach(b -> {
//            Book book = apiMapper.mapApiToEntity(b);
//            bookdao.addBook(book);
//
//        });
    }

    private WebTarget getBookClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(URI);
    }

    private WebTarget getAuthorClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(AUTHOR_URI);
    }
}
