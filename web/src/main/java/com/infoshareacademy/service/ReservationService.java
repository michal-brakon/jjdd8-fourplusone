package com.infoshareacademy.service;

import com.infoshareacademy.dao.ReservationDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.dto.ReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Optional;
import java.util.UUID;


@Stateless
public class ReservationService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private ReservationDao reservationDao;

    @EJB
    private BookService bookService;

    @EJB
    private UserService userService;

    public void addReservation(ReservationDTO reservationDTO) {

        Long bookId = reservationDTO.getBookId();
        Long userId = reservationDTO.getUserId();

        Reservation reservation = new Reservation();

        reservation.setBook(bookService.getById(bookId));
        reservation.setUser(userService.getById(userId));
        reservation.setCreateTimestamp(reservationDTO.getBorrowDate());
        reservation.setToken(UUID.randomUUID().toString());

        reservationDao.addReservation(reservation);
        bookService.increaseReservationCount(bookId);
    }

    public Optional<Reservation> findReservationByBook (Book book)  {
        return reservationDao.findReservationByBook(book);
    }

    public Optional<Reservation> findReservationByToken(String token) {
        return reservationDao.findReservationByToken(token);
    }

    public void removeReservation (Reservation reservation)   {
        reservationDao.removeReservation(reservation);
    }

}
