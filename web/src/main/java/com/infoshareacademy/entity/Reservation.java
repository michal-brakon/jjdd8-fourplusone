package com.infoshareacademy.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "library")

public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "borrow_date", nullable = true)
    private Date borrowDate;

    @Column(name = "return_date", nullable = true)
    private Date returnDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }



    public Date getBorrowDate() {
        return borrowDate;
    }


    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }


    public Date getReturnDate() {
        return returnDate;
    }


    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
