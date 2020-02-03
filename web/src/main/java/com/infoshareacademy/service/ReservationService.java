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
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
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

    @EJB
    private AuthorService authorService;

    @EJB
    private MailSender mailSender;

    @Transactional
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
        authorService.increaseReservationCount(bookService.getById(bookId).getAuthor());
        mailSender.approveReservation(reservation.getUser().getEmail(), reservation);

    }

    public Optional<Reservation> findReservationByBook (Book book)  {
        return reservationDao.findReservationByBook(book);
    }

    public Optional<Reservation> findReservationByToken(String token) {
        return reservationDao.findReservationByToken(token);
    }

    public void removeReservation (Reservation reservation) throws IOException {
        mailSender.reservationRejected(reservation.getUser().getEmail(), reservation);
        reservationDao.removeReservation(reservation);
    }

    public void confirm (Reservation reservation)  {
        reservation.setConfirm(true);
        reservationDao.confirm(reservation);
    }

    public void removeUnconfirmedReservations ()  {
        List<Reservation> reservations = reservationDao.findAll();
        if (!reservations.isEmpty())  {
            reservations.stream()
                    .filter(r -> r.getExpirationTime().toLocalDateTime().isBefore(LocalDateTime.now()))
                    .filter(r -> r.getConfirm()==null)
                    .forEach(r -> {
                        try {
                            removeReservation(r);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
