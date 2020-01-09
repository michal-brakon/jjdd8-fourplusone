package com.infoshareacademy.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "epoch", schema = "Library")
public class Epoch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = true, length = 15)
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
