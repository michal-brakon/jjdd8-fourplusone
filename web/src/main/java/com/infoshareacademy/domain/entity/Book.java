package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book", schema = "library")
@NamedQueries({
        @NamedQuery(name = "Book.getById",
                query = "SELECT b FROM Book b WHERE b.id=:id"),

        @NamedQuery(name = "Book.findAll",
                query = "SELECT b FROM Book b"),

        @NamedQuery(name = "Book.getId",
                query = "SELECT b.id FROM Book b order by b.id"),

        @NamedQuery(name = "Books.details",
                query = "SELECT b FROM Book b WHERE b.id in :ids"),

        @NamedQuery(name = "Book.countAll",
                query = "SELECT COUNT(b) FROM Book b"),

         @NamedQuery(name = "Book.findByTitle",
                query = "SELECT b FROM Book b JOIN b.author a WHERE b.title LIKE :inputParam OR a.name LIKE :inputParam"),

        @NamedQuery(name = "Book.findAudioBooks",
                query = "SELECT b FROM Book b WHERE b.hasAudio = true"),

        @NamedQuery(name = "Book.countAudio",
                query = "SELECT COUNT(b) FROM Book b WHERE b.hasAudio = true"),

        @NamedQuery(name = "Book.findEpic",
                query = "SELECT b FROM Book b WHERE b.kind = 1"),

        @NamedQuery(name = "Book.findLyric",
                query = "SELECT b FROM Book b WHERE b.kind = 2"),

        @NamedQuery(name = "Book.findDrama",
                query = "SELECT b FROM Book b WHERE b.kind = 3"),

        @NamedQuery(name = "Book.countEpic",
                query = "SELECT COUNT(b) FROM Book b WHERE b.kind = 1"),

        @NamedQuery(name = "Book.countLyric",
                query = "SELECT COUNT(b) FROM Book b WHERE b.kind = 2"),

        @NamedQuery(name = "Book.countDrama",
                query = "SELECT COUNT(b) FROM Book b WHERE b.kind = 3")
}
)

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "cover")
    private String cover;

    @Column(name = "has_audio")
    private Boolean hasAudio;

    @Column(name = "simple_thumb")
    private String simpleThumb;

    @Column(name = "cover_thumb")
    private String coverThumb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "epoch_id")
    private Epoch epochId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "literature_kind_id")
    private LiteratureKind kind;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                        CascadeType.MERGE,
                        CascadeType.REFRESH,
                       CascadeType.DETACH})
    @JoinColumn(name = "author_id")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Epoch getEpochId() {
        return epochId;
    }

    public void setEpoch(Epoch epochId) {
        this.epochId = epochId;
    }

    public LiteratureKind getKind() {
        return kind;
    }

    public void setKind(LiteratureKind kind) {
        this.kind = kind;
    }
}
