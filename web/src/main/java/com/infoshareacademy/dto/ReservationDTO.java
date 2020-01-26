package com.infoshareacademy.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationDTO {

    private Long userId;
    private Long bookId;
    private Timestamp borrowDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }
}
