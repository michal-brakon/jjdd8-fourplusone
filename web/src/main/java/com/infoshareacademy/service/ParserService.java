package com.infoshareacademy.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ParserService {


    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> parse(String json, Class<T> tClass) throws IOException {
        CollectionType listType = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        List<T> ts = mapper.readValue(json, listType);
        logger.debug("class name: {}", ts.get(0).getClass().getName());
        return ts;
    }

    public <T> List<T> parseBookFromFile(File json, Class<T> tClass) throws IOException {
        CollectionType listType = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        List<T> ts = mapper.readValue(json, listType);
        logger.debug("class name: {}", ts.get(0).getClass().getName());
        return ts;
    }

//    public List<BookJson> parseBookFromFile(String filename) {
//        try {
//            File file = new File(filename);
//            return mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                    .readValue(file, new TypeReference<>() {
//                    });
//        } catch (JsonProcessingException e) {
//            logger.error("Json parsing fail ", e);
//
//        } catch (IOException e) {
//            logger.error("Error while loading file ", e);
//        }
//        return new ArrayList<>();
//    }
}
