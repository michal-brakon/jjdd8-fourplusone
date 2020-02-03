package com.infoshareacademy.service;

import com.infoshareacademy.dto.BookDTO;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;

//@Startup
//@Singleton
public class ApiStarter {

    @Inject
    ParserService parserService;

    @Inject
    ApiDataInitializer apiDataInitializer;

    @Inject
    BookService bookService;

  //  @PostConstruct
    private void setApi()  {

        List<BookDTO> books = parserService.parse(apiDataInitializer.getApiFromUrl(), BookDTO.class);
        bookService.addBooks(books);
    }
}
