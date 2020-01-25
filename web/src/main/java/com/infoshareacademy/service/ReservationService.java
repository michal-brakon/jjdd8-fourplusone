package com.infoshareacademy.service;

import com.infoshareacademy.dao.ReservationDao;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.dto.ReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Stateless
public class ReservationService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private ReservationDao reservationDao;

    @EJB
    private BookService bookService;

    @EJB
    private UserService userService;

    public void addReservation (ReservationDTO reservation)  {

        Long bookId = reservation.getBookId();
        Long userId = reservation.getUserId();

        Reservation reservationDaoToEntity = new Reservation();

        reservationDaoToEntity.setBookId(bookService.getById(bookId));
        reservationDaoToEntity.setUserId(userService.getById(userId));
        reservationDaoToEntity.setBorrowDate(Timestamp.valueOf(LocalDateTime.now()));

        reservationDao.addReservation(reservationDaoToEntity);
    }

}
