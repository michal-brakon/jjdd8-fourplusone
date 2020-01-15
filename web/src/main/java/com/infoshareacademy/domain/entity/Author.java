package com.infoshareacademy.domain.entity;

import javax.persistence.*;

@NamedQuery(
        name = "Author.findAuthorByName",
        query = "SELECT a FROM Author a WHERE a.name = :name")

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
