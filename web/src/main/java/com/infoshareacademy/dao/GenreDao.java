package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GenreDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addGenre(Genre genre) {
        em.persist(genre);
        logger.debug("new genre was created {}", genre);
    }
}


