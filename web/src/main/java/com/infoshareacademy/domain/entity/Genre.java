package com.infoshareacademy.domain.entity;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(
                name = "Genre.findGenreByName",
                query = "SELECT g FROM Genre g WHERE g.name = :name"
        ),
        @NamedQuery(name = "Genre.getAll",
                query = "SELECT g FROM Genre g ")})

@Entity
@Table(name = "genre", schema = "library",
        indexes = {@Index(name = "genre_idx", columnList = "name")})
public class Genre {

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
