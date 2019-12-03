package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String kind;
    private String author;
    private String epoch;
    private String title;
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

    public Book(ExternalBook exBook) {
        this.author = exBook.getAuthor();
        this.genre = exBook.getGenre();
    }


    public List<Book> addbooks () {
        ArrayList<Book> result = new ArrayList<Book>();
        for (ExternalBook record : ExternalBook.externalBooks) {
            result.add(new Book(record));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "kind='" + kind + '\'' +
                ", author='" + author + '\'' +
                ", epoch='" + epoch + '\'' +
                ", title='" + title + '\'' +
                ", hasAudio=" + hasAudio +
                ", genre='" + genre + '\'' +
                '}';
    }


   }
