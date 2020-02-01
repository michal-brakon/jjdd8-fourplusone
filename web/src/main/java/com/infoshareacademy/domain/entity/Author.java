package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedQueries({
        @NamedQuery(name = "Author.forLiveSearch",
                query = "SELECT a FROM Author a where a.name LIKE :param"),

        @NamedQuery(
                name = "Author.findAuthorByName",
                query = "SELECT a FROM Author a WHERE a.name = :name"),

        @NamedQuery(name = "Author.getAll",
                query = "SELECT a FROM Author a")})
@Entity
@Table(name = "author", schema = "library",
        indexes = {@Index(name = "author_idx", columnList = "name")})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
