package com.infoshareacademy.service;

import com.infoshareacademy.dao.*;
import com.infoshareacademy.domain.api.*;
import com.infoshareacademy.domain.entity.*;
import com.infoshareacademy.mapper.*;
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
    private BookMapper bookMapper;

    @Inject
    private AuthorMapper authorMapper;

    @Inject
    private BookDao bookdao;

    @Inject
    private AuthorDao authorDao;

    @Inject
    private KindDao kindDao;

    @Inject
    private KindMapper kindMapper;

    @Inject
    private GenreDao genreDao;

    @Inject
    private GenreMapper genreMapper;

    @Inject
    private EpochDao epochDao;

    @Inject
    private EpochMapper epochMapper;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private static final String URI = "http://isa-proxy.blueazurit.com/books/books/";
    private static final String AUTHOR_URI = "http://isa-proxy.blueazurit.com/books/authors/";
    private static final String KIND_URI = "http://isa-proxy.blueazurit.com/books/kinds/";
    private static final String GENRE_URI = "http://isa-proxy.blueazurit.com/books/genres/";
    private static final String EPOCH_URI = "http://isa-proxy.blueazurit.com/books/epochs/";


    @PostConstruct
    public void setApi() throws IOException {

        List<AuthorJson> authorJsons = bookApiConsumer.consume(getAuthorClientTarget(), AuthorJson.class);
        authorJsons.forEach(authorJson -> {
            Author author = authorMapper.mapApiRequestToEntity(authorJson);
            authorDao.addAuthor(author);});

        List<KindJson> kindJsons = bookApiConsumer.consume(getKindClientTarget(), KindJson.class);
        kindJsons.forEach(kindJson -> {
            LiteratureKind kind = kindMapper.mapApiRequestToEntity(kindJson);
            kindDao.addKind(kind);});

        List<GenreJson> genreJsonList = bookApiConsumer.consume(getGenreClientTarget(), GenreJson.class);
        genreJsonList.forEach(b -> {
            Genre genre = genreMapper.mapApiRequestToEntity(b);
            genreDao.addGenre(genre);});

        List<EpochJson> epochJsonList = bookApiConsumer.consume(getEpochClientTarget(), EpochJson.class);
        epochJsonList.forEach(b -> {
            Epoch epoch = epochMapper.mapApiRequestToEntity(b);
            epochDao.addEpoch(epoch);});

        List<BookJson> bookJsonList = bookApiConsumer.consume(getBookClientTarget(), BookJson.class);
        bookJsonList.forEach(b -> {
            Book book = bookMapper.mapApiToEntity(b);
            Author authorByName = authorDao.findAuthorByName(b.getAuthor());
            LiteratureKind kindByName = kindDao.findKindByName(b.getKind());
            Genre genreByName = genreDao.findGenreByName(b.getGenre());
            Epoch epochByName = epochDao.findEpochByName(b.getEpoch());
            book.setAuthor(authorByName);
            book.setGenre(genreByName);
            book.setKind(kindByName);
            book.setEpoch(epochByName);
            bookdao.addBook(book);});
    }

    private WebTarget getGenreClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(GENRE_URI);
    }

    private WebTarget getEpochClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(EPOCH_URI);
    }

    private WebTarget getBookClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(URI);
    }

    private WebTarget getKindClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(KIND_URI);
    }

    private WebTarget getAuthorClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(AUTHOR_URI);
    }
}
