package com.infoshareacademy.service;

import com.infoshareacademy.dao.ReservationDao;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.dto.ReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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

        reservationDaoToEntity.setBook(bookService.getById(bookId));
        reservationDaoToEntity.setUser(userService.getById(userId));
        reservationDaoToEntity.setBorrowDate(reservation.getBorrowDate());

        reservationDao.addReservation(reservationDaoToEntity);
        bookService.increaseReservationCount(bookId);
    }

}
