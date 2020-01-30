package com.infoshareacademy.service;

import com.infoshareacademy.dao.ReservationDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.dto.ReservationDTO;
import com.infoshareacademy.service.email.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
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

    @Inject
    MailSender mailSender;

    public void addReservation(ReservationDTO reservationDTO) throws IOException {

        Long bookId = reservationDTO.getBookId();
        Long userId = reservationDTO.getUserId();

        Reservation reservation = new Reservation();

        reservation.setBook(bookService.getById(bookId));
        reservation.setUser(userService.getById(userId));
        reservation.setCreateTimestamp(reservationDTO.getBorrowDate());
        reservation.setExpirationTime(reservationDTO.getExpiredTime());
        reservation.setToken(UUID.randomUUID().toString());

        reservationDao.addReservation(reservation);
        bookService.increaseReservationCount(bookId);
        mailSender.approveReservation("lucas83122@gmail.com", reservation);

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

    public void confirm (Reservation reservation)  {
        reservation.setConfirm(true);
        reservationDao.confirm(reservation);
    }
}
