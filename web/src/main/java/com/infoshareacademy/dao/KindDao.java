package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.LiteratureKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class KindDao {


    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public Long addKind(String name){
        LiteratureKind litKind = new LiteratureKind();
        litKind.setName(name);
        this.em.persist(litKind);
        logger.debug("new kind was created {}", litKind);
        return litKind.getId();
    }
}
