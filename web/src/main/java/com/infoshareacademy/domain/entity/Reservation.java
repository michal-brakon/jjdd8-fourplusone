package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "reservation", schema = "library")


@NamedQueries({
        @NamedQuery(name = "Reservation.getByUserId",
                query = "SELECT r FROM Reservation r WHERE r.user=:id"),
        @NamedQuery(name = "Reservation.getByBookId",
                query = "SELECT r FROM Reservation r WHERE r.book=:id")
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

    @Column(name = "borrow_date")
    private Timestamp borrowDate;

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

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

}