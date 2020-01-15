package com.infoshareacademy.domain.entity;

import javax.persistence.*;
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
