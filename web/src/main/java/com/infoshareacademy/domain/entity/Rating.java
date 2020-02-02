package com.infoshareacademy.domain.entity;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(name = "Rating.findByBook",
                query = "SELECT r FROM Rating r WHERE r.book=:book"),
        @NamedQuery(name = "Rating.getScoresByBook",
                query = "SELECT SUM (r.scores) FROM Rating r WHERE r.book=:book")
})
@Entity
@Table(name = "rating", schema = "library")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "scores")
    private Long scores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScores() {
        return scores;
    }

    public void setScores(Long scores) {
        this.scores = scores;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
