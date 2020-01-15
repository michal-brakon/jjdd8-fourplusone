package com.infoshareacademy.service;

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

@Stateless
public class ApiLoaderFromFile {

    @Inject
    ParserService parserService;

    @Inject
    BookDao bookDao;

    @Inject
    ApiMapper apiMapper;

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
            bookDao.addBook(book);
        });
        return file;
    }
}
