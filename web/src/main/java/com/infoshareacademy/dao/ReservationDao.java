package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReservationDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addReservation(Reservation reservation) {
        em.persist(reservation);

        logger.debug("new reservation was created: {}", reservation);
    }

    public Reservation findReservationByBook(Book bookId) {
        Query query = em.createNamedQuery("Reservation.getByBookId");
        query.setParameter("id", bookId.getId());
        return (Reservation) query.getResultList().get(0);
    }

    public List<Reservation> findReservationByUser(User userId)  {
        Query query = em.createNamedQuery("Reservation.getByUserId");
        query.setParameter("id", userId.getId());
        return query.getResultList();
    }
    public void deleteReservation (Reservation reservation)  {
        em.remove(reservation);

        logger.debug("reservation {} was removed", reservation);
    }

}
