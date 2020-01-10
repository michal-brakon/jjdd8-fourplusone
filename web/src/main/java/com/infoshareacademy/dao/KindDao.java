package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.LiteratureKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class KindDao {


    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addKind(LiteratureKind kind){
        em.persist(kind);
        logger.debug("new kind was created {}", kind);
           }
}
