package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.entity.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ReservationDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addReservation(Reservation reservation) {
        em.persist(reservation);

        logger.debug("new reservation was created: {}", reservation);
    }

    public Reservation findReservationByBook(Long bookId) {
        Query query = em.createNamedQuery("Reservation.getByBookId");
        query.setParameter("id", bookId);
        return (Reservation) query.getResultList().get(0);
    }

//    public void findAll

}
