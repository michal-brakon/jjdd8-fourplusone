package com.infoshareacademy.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
@IdClass(BookPK.class)
public class Book {
    private int id;
    private String title;
    private String cover;
    private Byte hasAudio;
    private String simpleThumb;
    private String coverThumb;
    private int epochId;
    private int genreId;
    private int literatureKindId;
    private int authorId;
    private Author authorByAuthorId;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "cover", nullable = true, length = 255)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "has_audio", nullable = true)
    public Byte getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(Byte hasAudio) {
        this.hasAudio = hasAudio;
    }

    @Basic
    @Column(name = "simple_thumb", nullable = true, length = 255)
    public String getSimpleThumb() {
        return simpleThumb;
    }

    public void setSimpleThumb(String simpleThumb) {
        this.simpleThumb = simpleThumb;
    }

    @Basic
    @Column(name = "cover_thumb", nullable = true, length = 255)
    public String getCoverThumb() {
        return coverThumb;
    }

    public void setCoverThumb(String coverThumb) {
        this.coverThumb = coverThumb;
    }

    @Id
    @Column(name = "epoch_id", nullable = false)
    public int getEpochId() {
        return epochId;
    }

    public void setEpochId(int epochId) {
        this.epochId = epochId;
    }

    @Id
    @Column(name = "genre_id", nullable = false)
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Id
    @Column(name = "literature_kind_id", nullable = false)
    public int getLiteratureKindId() {
        return literatureKindId;
    }

    public void setLiteratureKindId(int literatureKindId) {
        this.literatureKindId = literatureKindId;
    }

    @Id
    @Column(name = "author_id", nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return id == that.id &&
                epochId == that.epochId &&
                genreId == that.genreId &&
                literatureKindId == that.literatureKindId &&
                authorId == that.authorId &&
                Objects.equals(title, that.title) &&
                Objects.equals(cover, that.cover) &&
                Objects.equals(hasAudio, that.hasAudio) &&
                Objects.equals(simpleThumb, that.simpleThumb) &&
                Objects.equals(coverThumb, that.coverThumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cover, hasAudio, simpleThumb, coverThumb, epochId, genreId, literatureKindId, authorId);
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id",  insertable = false, updatable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
