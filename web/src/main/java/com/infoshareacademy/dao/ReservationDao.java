package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class ReservationDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addReservation(Reservation reservation) {
        em.persist(reservation);

        logger.debug("new reservation was created: {}", reservation);
    }

    public Optional<Reservation> findReservationByBook(Book book) {
        Query query = em.createNamedQuery("Reservation.getByBook");
        query.setParameter("book", book);
        if (query.getResultList().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of((Reservation) query.getResultList().get(0));
    }

    public List<Reservation> findReservationByUser(User user) {
        Query query = em.createNamedQuery("Reservation.getByUser");
        query.setParameter("user", user);
        return query.getResultList();
    }

    public void removeReservation(Reservation reservation) {
        em.remove(reservation);
        logger.debug("reservation {} was removed", reservation);
    }

    public Optional<Reservation> findReservationByActivationLink (String activationLink) {
        Query query = em.createNamedQuery("Reservation.getByToken");
        query.setParameter("token", activationLink);
        if (query.getResultList().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of((Reservation) query.getResultList().get(0));
    }
}
