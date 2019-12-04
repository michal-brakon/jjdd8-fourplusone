package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    private String kind;

    private String author;

    private String epoch;

    private String title;

    @JsonProperty("has_audio")
    private boolean hasAudio;

    private String genre;


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

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "kind='" + kind + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", epoch='" + epoch + '\'' +
                ", hasAudio=" + hasAudio +
                ", genre='" + genre + '\'' +
                '}';
    }


}
