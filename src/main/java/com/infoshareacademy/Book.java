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

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    private String hasAudioString = hasAudio ? "tak" : "nie";

    public String favourite = "nie";

    @Override
    public String toString() {
        return "id : " + id +
                "  Tytuł : " + title + '\n' +
                "Rodzaj literacki : " + kind + '\n' +
                "Autor : " + author + '\n' +
                "Epoka : " + epoch + '\n' +
                "Czy ma Audio : " + hasAudioString + '\n' +
                "Gatunek literacki : " + genre + '\n'+
                "Czy ulubiona : " + favourite + '\n' + '\n';
    }
}
