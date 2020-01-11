package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.mapper.BookMapper;
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
    private BookMapper bookMapper;

    @PersistenceContext
    private EntityManager em;

    public void setAuthor(Author author) {
        em.persist(author);

        logger.debug("new author was created {}",author);
    }
}

