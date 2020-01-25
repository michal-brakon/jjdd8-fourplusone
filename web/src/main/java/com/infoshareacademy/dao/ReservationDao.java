package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.entity.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addReservation(Reservation reservation) {
        em.persist(reservation);

        logger.debug("new reservation was created: {}", reservation);
    }

//    public void findAll

}
