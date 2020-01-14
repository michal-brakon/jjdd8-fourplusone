package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.LiteratureKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class KindDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addKind(LiteratureKind kind) {
        em.persist(kind);
        logger.debug("new kind was created {}", kind);
    }

    public LiteratureKind findKindByName(String name) {

        Query query = em.createNamedQuery("Kind.findAuthorByName");
        query.setParameter("name", name);

        List<LiteratureKind> resultList = query.getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
