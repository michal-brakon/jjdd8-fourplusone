package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.exception.ApiFileNotFound;
import com.infoshareacademy.mapper.ApiMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Stateless
public class ApiLoaderToFile {

    @Inject
    ParserService parserService;

    @Inject
    BookDao bookdao;

    @Inject
    ApiMapper apiMapper;



    private static final String SETTINGS_FILE = "settings.properties";

    public void getFromURL (String url) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File(SETTINGS_FILE + "json.txt"), objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(url, new TypeReference<>() {
                }));
    }

    public File uploadApiFile(Part filePart) throws ApiFileNotFound, IOException {

        String filename = Paths.get(filePart.getSubmittedFileName())
                .getFileName().toString();

        if (filename == null || filename.isEmpty()) {
            throw new ApiFileNotFound("No API file has been uploaded");
        }

        File file = new File(filename);
        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();

        Files.copy(fileContent, file.toPath());

        fileContent.close();

        parserService.parseBookFromFile(file.getAbsolutePath()).forEach(b -> {
            Book book = apiMapper.mapApiToEntity(b);
            bookdao.addBook(book);
        });

        return file;
    }
}
