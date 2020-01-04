package com.infoshareacademy.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
@IdClass(BookPK.class)
public class Book {
    private Long id;
    private String title;
    private String cover;
    private Byte hasAudio;
    private String simpleThumb;
    private String coverThumb;
    private Long epochId;
    private Long genreId;
    private Long literatureKindId;
    private Long authorId;
    private Author authorByAuthorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "cover", nullable = true, length = 255)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "has_audio", nullable = true)
    public Byte getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(Byte hasAudio) {
        this.hasAudio = hasAudio;
    }

    @Column(name = "simple_thumb", nullable = true, length = 255)
    public String getSimpleThumb() {
        return simpleThumb;
    }

    public void setSimpleThumb(String simpleThumb) {
        this.simpleThumb = simpleThumb;
    }


    @Column(name = "cover_thumb", nullable = true, length = 255)
    public String getCoverThumb() {
        return coverThumb;
    }

    public void setCoverThumb(String coverThumb) {
        this.coverThumb = coverThumb;
    }

    @Id
    @Column(name = "epoch_id")
    public Long getEpochId() {
        return epochId;
    }

    public void setEpochId(Long epochId) {
        this.epochId = epochId;
    }

    @Id
    @Column(name = "genre_id")
    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    @Id
    @Column(name = "literature_kind_id")
    public Long getLiteratureKindId() {
        return literatureKindId;
    }

    public void setLiteratureKindId(Long literatureKindId) {
        this.literatureKindId = literatureKindId;
    }

    @Id
    @Column(name = "author_id")
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
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
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
