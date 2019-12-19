package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;

public class Book {
    Language l = new Language();



    private String kind;

    private String author;

    private String epoch;

    private String title;

    @JsonProperty("has_audio")
    private boolean hasAudio;

    private String genre;

    public  String getKind() {
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

    @Override
    public String toString() {
        return l.getMessageByKey(LangKeyConfig.TITLE) + title + '\n' +
                "Rodzaj literacki : " + kind + '\n' +
                l.getMessageByKey(LangKeyConfig.AUTHOR) + author + '\n' +
                l.getMessageByKey(LangKeyConfig.EPOCH) + epoch + '\n' +
                l.getMessageByKey(LangKeyConfig.HAS_AUDIO) + hasAudioString + '\n' +
                l.getMessageByKey(LangKeyConfig.GENRE) + genre + '\n' + '\n';
    }
}
