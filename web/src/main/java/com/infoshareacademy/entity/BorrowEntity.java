package com.infoshareacademy.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "borrow", schema = "Library_DB")
@IdClass(BorrowEntityPK.class)
public class BorrowEntity {
    private int id;
    private int bookId;
    private int userId;
    private Date borrowDate;
    private Date returnDate;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "borrow_date", nullable = true)
    public Date getBorrowDate() {
        return borrowDate;
    }

/*    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }*/

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Basic
    @Column(name = "return_date", nullable = true)
    public Date getReturnDate() {
        return returnDate;
    }

   /* public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }
*/
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowEntity that = (BorrowEntity) o;
        return id == that.id &&
                bookId == that.bookId &&
                userId == that.userId &&
                Objects.equals(borrowDate, that.borrowDate) &&
                Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, userId, borrowDate, returnDate);
    }
}
