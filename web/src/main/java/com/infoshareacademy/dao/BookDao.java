package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.AuthorView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @PersistenceContext
    private EntityManager em;

    public Book getById(Long id) {
        return em.find(Book.class, id);
    }

    public long getBookAuthors(Long id) {

        Query query = em.createNamedQuery("Book.getAuthorId");

        String s = query.toString();


        return Long.parseLong(s);

    }

    public void addBook(Book book) {

        em.persist(book);
        logger.info("New book was added :{}", book);
    }
}

