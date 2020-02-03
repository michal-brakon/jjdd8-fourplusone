package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Rating;
import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Stateless
public class RatingDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addRating (Rating rating)  {
        em.persist(rating);
        logger.debug("new rating was created");
    }

    public Optional<Rating> findRatingByBook (Book book) {
        Query query = em.createNamedQuery("Rating.findByBook");
        query.setParameter("book", book);

        if (query.getResultList().isEmpty()) {
            return Optional.empty();
    }
        return Optional.of((Rating) query.getResultList().get(0));
}
    public Long getScoresByBook (Book book) {
        Query query = em.createNamedQuery("Rating.getScoresByBook");
        query.setParameter("book", book);

        return (Long) query.getSingleResult();
    }

}
