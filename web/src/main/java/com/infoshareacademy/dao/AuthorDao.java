package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AuthorDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addAuthor(Author author) {
        em.persist(author);

        logger.debug("new author was created {}",author);
    }

    public List<Author> findAuthorByName(String name){

        Query query = em.createNamedQuery("Author.findAuthorByName");
                query.setParameter("author" , name);
                return query.getResultList();
    }
}

