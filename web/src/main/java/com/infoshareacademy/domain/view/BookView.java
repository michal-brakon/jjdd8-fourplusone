package com.infoshareacademy.domain.view;

import javax.inject.Inject;

public class BookView {

    @Inject
    AuthorView authorView;
    @Inject
    KindView kindView;
    @Inject
    GenreView genreView;
    @Inject
    EpochView epochView;

    String title;
    String cover;
    boolean audio;
    String author = authorView.getName();
    String kind = kindView.getName();
    String genre = genreView.getName();
    String epoch = epochView.getName();

    public AuthorView getAuthorView() {
        return authorView;
    }

    public void setAuthorView(AuthorView authorView) {
        this.authorView = authorView;
    }

    public KindView getKindView() {
        return kindView;
    }

    public void setKindView(KindView kindView) {
        this.kindView = kindView;
    }

    public GenreView getGenreView() {
        return genreView;
    }

    public void setGenreView(GenreView genreView) {
        this.genreView = genreView;
    }

    public EpochView getEpochView() {
        return epochView;
    }

    public void setEpochView(EpochView epochView) {
        this.epochView = epochView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public boolean isAudio() {
        return audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }
}
