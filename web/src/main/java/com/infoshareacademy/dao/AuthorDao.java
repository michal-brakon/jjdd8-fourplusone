package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.mapper.ApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuthorDao {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private ApiMapper apiMapper;

    @PersistenceContext
    private EntityManager em;

    public void addAuthor(Author author) {
        em.persist(author);

        logger.debug("new author was created {}",author);
    }
}

