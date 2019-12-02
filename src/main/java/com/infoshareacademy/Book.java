package com.infoshareacademy;

public class Book {

    String kind;
    String full_sort_key;
    String title;
    String url;
    String author;
    String epoch;
    String href;
    boolean has_audio;
    String genre;
    String slug;



    public Book(String kind, String full_sort_key, String title, String url, String author, String epoch, String href, boolean has_audio, String genre, String slug) {
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
}
