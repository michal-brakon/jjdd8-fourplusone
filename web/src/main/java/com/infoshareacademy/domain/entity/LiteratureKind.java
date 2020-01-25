package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Kind.findAuthorByName",
        query = "SELECT k FROM LiteratureKind k WHERE k.name = :name"
)
@Entity
@Table(name = "literature_kind", schema = "library",
        indexes = {@Index(name = "kind_idx", columnList = "name")})
public class LiteratureKind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "kind")
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
