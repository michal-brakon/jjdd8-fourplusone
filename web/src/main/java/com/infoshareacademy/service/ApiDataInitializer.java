package com.infoshareacademy.service;

import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.api.AuthorJson;
import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.entity.Book;
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
import java.io.IOException;
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
    public void setApi() throws IOException {

        List<AuthorJson> authorJsons = bookApiConsumer.consume(getAuthorClientTarget(), AuthorJson.class);
        authorJsons.forEach(authorJson ->{
                Author author = authorMapper.mapApiRequestToEntity(authorJson);
        authorDao.addAuthor(author);




        });
        List<BookJson> bookJsonList = bookApiConsumer.consume(getBookClientTarget(),BookJson.class);
        bookJsonList.forEach(b -> {
            Book book = apiMapper.mapApiToEntity(b);
            bookdao.addBook(book);

        });
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
