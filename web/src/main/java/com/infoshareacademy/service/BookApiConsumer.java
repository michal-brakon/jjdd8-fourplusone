package com.infoshareacademy.service;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Stateless
public class BookApiConsumer {


    @Inject
    private ParserService parserService;

    public <T> List<T> consume(WebTarget webTarget, Class<T> tClass) throws IOException {
        Response response = webTarget.request().get();
        String resp = response.readEntity(String.class);
        response.close();
        return parserService.parse(resp, tClass);
    }


}
