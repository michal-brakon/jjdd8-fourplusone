package com.infoshareacademy.service;

import com.infoshareacademy.dao.*;
import com.infoshareacademy.domain.api.AuthorJson;
import com.infoshareacademy.domain.api.BookJson;
import com.infoshareacademy.domain.api.EpochJson;
import com.infoshareacademy.domain.api.GenreJson;
import com.infoshareacademy.domain.api.KindJson;
import com.infoshareacademy.domain.entity.*;
import com.infoshareacademy.exception.ApiFileNotFound;
import com.infoshareacademy.mapper.*;
import com.infoshareacademy.mapper.BookMapper;

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

//    @Inject
//    private BookApiConsumer bookApiConsumer;
//
//    @Inject
//    private BookMapper bookMapper;
//
//    @Inject
//    private AuthorMapper authorMapper;
//
//    @Inject
//    private BookDao bookdao;
//
//    @Inject
//    private AuthorDao authorDao;
//
//    @Inject
//    private KindDao kindDao;
//
//    @Inject
//    private KindMapper kindMapper;
//
//    @Inject
//    private GenreDao genreDao;
//
//    @Inject
//    private GenreMapper genreMapper;
//
//    @Inject
//    private EpochDao epochDao;
//
//    @Inject
//    private EpochMapper epochMapper;
//
//    @Inject
//    private ParserService parserService;

//    public File uploadApiFile(Part filePart) throws ApiFileNotFound, IOException {
//
//        String filename = Paths.get(filePart.getSubmittedFileName())
//                .getFileName().toString();
//
//        if (filename == null || filename.isEmpty()) {
//            throw new ApiFileNotFound("No API file has been uploaded");
//        }
//        File file = new File(filename);
//        Files.deleteIfExists(file.toPath());
//
//        InputStream fileContent = filePart.getInputStream();
//
//        Files.copy(fileContent, file.toPath());
//
//        fileContent.close();
//
//        String fileToString = new String(Files.readAllBytes(Paths.get(String.valueOf(file.toPath()))));
//
//        parserService.parse(fileToString, BookJson.class).forEach(b -> {
//            Book book = bookMapper.mapApiToEntity(b);
//            Author authorByName = authorDao.findAuthorByName(b.getAuthor());
//            LiteratureKind kindByName = kindDao.findKindByName(b.getKind());
//            Genre genreByName = genreDao.findGenreByName(b.getGenre());
//            Epoch epochByName = epochDao.findEpochByName(b.getEpoch());
//            book.setAuthor(authorByName);
//            book.setGenre(genreByName);
//            book.setKind(kindByName);
//            book.setEpoch(epochByName);
//            bookdao.addBook(book);});
//
//        parserService.parse(fileToString, AuthorJson.class).forEach(b -> {
//            Author author = authorMapper.mapApiRequestToEntity(b);
//            authorDao.addAuthor(author);
//        });
//        parserService.parse(fileToString, EpochJson.class).forEach(b -> {
//            Epoch epoch = epochMapper.mapApiRequestToEntity(b);
//            epochDao.addEpoch(epoch);
//        });
//        parserService.parse(fileToString, GenreJson.class).forEach(b -> {
//            Genre genre = genreMapper.mapApiRequestToEntity(b);
//            genreDao.addGenre(genre);
//        });
//        parserService.parse(fileToString, KindJson.class).forEach(b -> {
//            LiteratureKind kind = kindMapper.mapApiRequestToEntity(b);
//            kindDao.addKind(kind);
//        });
//
//
//
//        return file;
//    }
}
