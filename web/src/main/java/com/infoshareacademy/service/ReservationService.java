package com.infoshareacademy.service;

import com.infoshareacademy.dao.ReservationDao;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.dto.ReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ReservationService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private ReservationDao reservationDao;

    public Reservation findOrAdd(Long bookId)  {

        Reservation reservation = reservationDao.findReservationByBook(bookId);
        if (reservation == null) {
            reservation = new Reservation();
            reservation.setBookId(bookId);
            authorDao.addAuthor(author);

        }
        return author;
    }

}
