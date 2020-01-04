package com.infoshareacademy.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BookPK implements Serializable {
    private int id;
    private int epochId;
    private int genreId;
    private int literatureKindId;
    private int authorId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "epoch_id", nullable = false)
    @Id
    public int getEpochId() {
        return epochId;
    }

    public void setEpochId(int epochId) {
        this.epochId = epochId;
    }

    @Column(name = "genre_id", nullable = false)
    @Id
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Column(name = "literature_kind_id", nullable = false)
    @Id
    public int getLiteratureKindId() {
        return literatureKindId;
    }

    public void setLiteratureKindId(int literatureKindId) {
        this.literatureKindId = literatureKindId;
    }

    @Column(name = "author_id", nullable = false)
    @Id
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
        BookPK that = (BookPK) o;
        return id == that.id &&
                epochId == that.epochId &&
                genreId == that.genreId &&
                literatureKindId == that.literatureKindId &&
                authorId == that.authorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, epochId, genreId, literatureKindId, authorId);
    }
}
