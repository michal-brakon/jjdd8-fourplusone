package com.infoshareacademy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.infoshareacademy.exception.ApiFileNotFound;
import com.infoshareacademy.service.BookService;
import com.infoshareacademy.service.ParserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;

@Stateless
@MultipartConfig
public class BookDTO {

    String author;
    String title;
    String epoch;
    String genre;
    String cover;
    String kind;

    @JsonProperty("cover_thumb")
    String coverThumb;

    @JsonProperty("has_audio")
    Boolean hasAudio;

    @JsonProperty("simple_thumb")
    String simpleThumb;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

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

    public Boolean getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public String getSimpleThumb() {
        return simpleThumb;
    }

    public void setSimpleThumb(String simpleThumb) {
        this.simpleThumb = simpleThumb;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
               ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", epoch='" + epoch + '\'' +
                ", genre='" + genre + '\'' +
                ", cover='" + cover + '\'' +
                ", kind='" + kind + '\'' +
                ", coverThumb='" + coverThumb + '\'' +
                ", hasAudio=" + hasAudio +
                ", simpleThumb='" + simpleThumb + '\'' +
                '}';
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
        parseBooksToDTO(file);
        return file;
    }

    public Set<BookDTO> parseBooksToDTO(File file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Set<BookDTO> bookSet = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(file, new TypeReference<>() {
                });

//        bookSet
//                .forEach(b -> System.out.println(b.getAuthor()));

        return bookSet;
    }
}
