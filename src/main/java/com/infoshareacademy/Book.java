package com.infoshareacademy;

public class Book {

    private String kind;
    private String full_sort_key;
    private String title;
    private String url;
    private String author;
    private String epoch;
    private String href;
    private boolean has_audio;
    private String genre;
    private String slug;

    public String getKind() {
        return kind;
    }

    public String getFull_sort_key() {
        return full_sort_key;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public String getEpoch() {
        return epoch;
    }

    public String getHref() {
        return href;
    }

    public boolean isHas_audio() {
        return has_audio;
    }

    public String getGenre() {
        return genre;
    }

    public String getSlug() {
        return slug;
    }

    public Book(String kind, String full_sort_key, String title, String url, String author, String epoch, String href, boolean has_audio, String genre) {
        this.kind = kind;
        this.full_sort_key = full_sort_key;
        this.title = title;
        this.url = url;
        this.author = author;
        this.epoch = epoch;
        this.href = href;
        this.has_audio = has_audio;
        this.genre = genre;
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + " Author: " + this.author + " Genre: " + this.genre + " Kind: " + this.kind;
    }
}
