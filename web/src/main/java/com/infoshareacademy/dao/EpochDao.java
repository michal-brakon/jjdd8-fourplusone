package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EpochDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addEpoch(Epoch epoch) {
        em.persist(epoch);

        logger.debug("new epoch was created {}", epoch);
    }
    public Epoch findEpochByName(String name) {

        Query query = em.createNamedQuery("Epoch.findEpochByName");
        query.setParameter("name", name);

        List<Epoch> resultList = query.getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
