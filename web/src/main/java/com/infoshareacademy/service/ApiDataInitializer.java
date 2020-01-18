package com.infoshareacademy.service;

import com.infoshareacademy.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ApiDataInitializer {

    @Inject
    private ParserService parserService;

    @Inject
    private BookService bookService;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private int checkStatus(String address) {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(address);
        try (Response response = webTarget.request().get()) {
            if (Response.Status.OK.equals(response.getStatusInfo())) {
                return response.getStatus();
            }
            int status = response.getStatus();
            throw new IllegalStateException("Error: " + status);
        }
    }

    private static final String URI = "http://isa-proxy.blueazurit.com/books/books/";
    private static final String AUTHOR_URI = "http://isa-proxy.blueazurit.com/books/authors/";
    private static final String KIND_URI = "http://isa-proxy.blueazurit.com/books/kinds/";
    private static final String GENRE_URI = "http://isa-proxy.blueazurit.com/books/genres/";
    private static final String EPOCH_URI = "http://isa-proxy.blueazurit.com/books/epochs/";


    public String getApiFromUrl() throws IOException {

        List<BookDTO> books = new ArrayList<>();
        //Client client = ClientBuilder.newClient();
        WebTarget webTarget = getBookClientTarget();
        String strResponse = "";
        try (Response response = webTarget.request().get()) {
            if (Response.Status.OK.equals(response.getStatusInfo())) {
                strResponse = response.readEntity(String.class);
                return strResponse;
            }
            int status = response.getStatus();
            throw new IllegalStateException("Error: " + status);
        }
    }


    private WebTarget getBookClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(URI);
    }

}

