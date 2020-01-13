package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQuery(
        name = "Author.findAuthorByName",
        query = "SELECT a FROM Author a WHERE a.name = :name"
)
@Entity
@Table(name = "author", schema = "library")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(
            mappedBy = "authors",
            fetch = FetchType.LAZY)
    Set<Book> books = new HashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

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

}
