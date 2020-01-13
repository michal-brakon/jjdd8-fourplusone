package com.infoshareacademy.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.api.BookJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ParserService {


    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ObjectMapper mapper = new ObjectMapper();

    public List<BookJson> parseBookFromUri(String jsonList) {
        try {
            return mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(jsonList, new TypeReference<>() {
                    });
        } catch (JsonProcessingException e) {
            logger.error("Json parsing fail ", e);
        }
        return new ArrayList<>();
    }

    public List<BookJson> parseBookFromFile(String filename) {
        try {
            File file = new File(filename);
            return mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(file, new TypeReference<>() {
                    });
        } catch (JsonProcessingException e) {
            logger.error("Json parsing fail ", e);

        } catch (IOException e) {
            logger.error("Json parsing fail ", e);
        }
        return new ArrayList<>();
    }
}
