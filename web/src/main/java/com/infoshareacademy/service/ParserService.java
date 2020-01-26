package com.infoshareacademy.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ParserService {


    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> parse(String json, Class<T> tClass) {
        try {
            CollectionType listType = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).getTypeFactory().constructCollectionType(ArrayList.class, tClass);
            List<T> ts = mapper.readValue(json, listType);
            return ts;
        } catch (IOException e) {
            logger.debug("class name: {}", e);
        }
        return null;

    }
}

