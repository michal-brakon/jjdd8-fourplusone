package com.infoshareacademy.domain.entity;

import javax.persistence.*;

@NamedQuery(
        name = "Epoch.findEpochByName",
        query = "SELECT e FROM Epoch e WHERE e.name = :name"
)
@Entity
@Table(name = "epoch", schema = "library",
        indexes = {@Index(name = "epoch_idx", columnList = "name")})
public class Epoch {

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