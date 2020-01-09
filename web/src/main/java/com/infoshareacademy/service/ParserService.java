package com.infoshareacademy.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.api.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;

@RequestScoped
public class ParserService {


    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ObjectMapper mapper = new ObjectMapper();

    public List<Book> parseBookFromUri(String jsonList) throws IOException {
        return mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonList, new TypeReference<>() {
                });

    }
}
