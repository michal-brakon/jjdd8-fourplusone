package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reservation", schema = "library")


@NamedQueries({
        @NamedQuery(name = "Reservation.getByUser",
                query = "SELECT r FROM Reservation r WHERE r.user=:user"),
        @NamedQuery(name = "Reservation.getByBook",
                query = "SELECT r FROM Reservation r WHERE r.book=:book"),
        @NamedQuery(name = "Reservation.getByToken",
                query = "SELECT r FROM Reservation r WHERE r.token=:token"),
        @NamedQuery(name = "Reservation.findAll",
                query = "SELECT r FROM Reservation r")
})

public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "create_time")
    private Timestamp createTimestamp;

    @Column(name = "expiration_time")
    private Timestamp expirationTime;

    @Column(name = "token")
    private String token;

    @Column(name = "confirmed")
    private Boolean isConfirm;

    public Boolean getConfirm() {
        return isConfirm;
    }

    public void setConfirm(Boolean confirm) {
        isConfirm = confirm;
    }

    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book bookId) {
        this.book = bookId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp borrowDate) {
        this.createTimestamp = borrowDate;
    }

}