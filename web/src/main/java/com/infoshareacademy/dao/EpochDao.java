package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Epoch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EpochDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addEpoch(Epoch epoch) {
        em.persist(epoch);

        logger.debug("new epoch was created {}", epoch);
    }
}
