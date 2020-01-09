package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book", schema = "library")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "cover", nullable = true, length = 255)
    private String cover;

    @Column(name = "has_audio", nullable = true)
    private Boolean hasAudio;

    @Column(name = "simple_thumb", nullable = true, length = 255)
    private String simpleThumb;

    @Column(name = "cover_thumb", nullable = true, length = 255)
    private String coverThumb;

    @ManyToOne
    @JoinColumn(name = "epoch_id")
    private Epoch epochId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "genre_set",
            joinColumns = {
                    @JoinColumn(name = "book_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "genre_id")})
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "literature_kind_id")
    private LiteratureKind literatureKindId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "authors_set",
            joinColumns = {
                    @JoinColumn(name = "book_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")})
    private Set<Author> authors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getCoverThumb() {
        return coverThumb;
    }

    public void setCoverThumb(String coverThumb) {
        this.coverThumb = coverThumb;
    }


    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }


    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


    public Epoch getEpochId() {
        return epochId;
    }

    public void setEpochId(Epoch epochId) {
        this.epochId = epochId;
    }


    public LiteratureKind getLiteratureKindId() {
        return literatureKindId;
    }

    public void setLiteratureKindId(LiteratureKind literatureKindId) {
        this.literatureKindId = literatureKindId;
    }
}
