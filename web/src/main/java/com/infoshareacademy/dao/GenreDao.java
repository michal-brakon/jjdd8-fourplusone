package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Genre;
import com.infoshareacademy.domain.entity.LiteratureKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class GenreDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addGenre(Genre genre) {
        em.persist(genre);
        logger.debug("new genre was created {}", genre);
    }
    public Genre findGenreByName(String name) {

        Query query = em.createNamedQuery("Genre.findGenreByName");
        query.setParameter("name", name);

        List<Genre> resultList = query.getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }
}


