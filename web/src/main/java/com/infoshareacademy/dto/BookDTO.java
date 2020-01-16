package com.infoshareacademy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.infoshareacademy.exception.ApiFileNotFound;
import com.infoshareacademy.service.ParserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;

@Stateless
public class BookDTO {


    @Inject
    ParserService parserService;


    String author;
    String title;
    String epoch;
    String genre;
    String cover;

    @JsonProperty("cover_thumb")
    String coverThumb;
    String has_audio;
    String simple_thumb;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoverThumb() {
        return coverThumb;
    }

    public void setCoverThumb(String coverThumb) {
        this.coverThumb = coverThumb;
    }

    public String getHas_audio() {
        return has_audio;
    }

    public void setHas_audio(String has_audio) {
        this.has_audio = has_audio;
    }

    public String getSimple_thumb() {
        return simple_thumb;
    }

    public void setSimple_thumb(String simple_thumb) {
        this.simple_thumb = simple_thumb;
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

        //String fileToString = new String(Files.readAllBytes(Paths.get(String.valueOf(file.toPath()))));

        return file;
    }

    public Set<BookDTO> saveBooksToDTO (File file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Set<BookDTO> bookSet = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(file, new TypeReference<>() {
                });

        return bookSet;
    }
}
