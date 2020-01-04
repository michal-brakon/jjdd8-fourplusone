package com.infoshareacademy.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BookPK implements Serializable {
    private Long id;
    private Long epochId;
    private Long genreId;
    private Long literatureKindId;
    private Long authorId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "epoch_id", nullable = false)
    @Id
    public Long getEpochId() {
        return epochId;
    }

    public void setEpochId(Long epochId) {
        this.epochId = epochId;
    }

    @Column(name = "genre_id", nullable = false)
    @Id
    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    @Column(name = "literature_kind_id", nullable = false)
    @Id
    public Long getLiteratureKindId() {
        return literatureKindId;
    }

    public void setLiteratureKindId(Long literatureKindId) {
        this.literatureKindId = literatureKindId;
    }

    @Column(name = "author_id", nullable = false)
    @Id
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
