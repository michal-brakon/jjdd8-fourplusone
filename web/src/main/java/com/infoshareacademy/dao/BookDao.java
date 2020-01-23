package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BookDao {

    private final int BOOK_LIMIT = 20;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addBook(Book book) {

        em.persist(book);
        logger.info("New book was added :{}", book);
    }

    public Book findById(Long id) {
        Query query = em.createNamedQuery("Book.getById");
        query.setParameter("id", id);
        return (Book) query.getSingleResult();
    }

    public List<Book> findAll() {
        Query query = em.createNamedQuery("Book.findAll");

        return query.getResultList();
    }

    public List<Book> findBooksLimit(int pageNumber) {
        Query query = em.createNamedQuery("Book.findAll");
        int limit = 21;
        query.setMaxResults(limit);
        query.setFirstResult((pageNumber - 1) * limit);
        return query.getResultList();
    }

    public List<Book> getBooksForPagination(int in) {
        Query query = em.createNamedQuery("Book.findAll");
        query.setFirstResult(in);
        query.setMaxResults(BOOK_LIMIT);
        return query.getResultList();
    }

    public List<Book> getAudioBooksForPagination(int in) {
        Query query = em.createNamedQuery("Book.findAudioBooks");
        query.setFirstResult(in);
        query.setMaxResults(BOOK_LIMIT);
        return query.getResultList();
    }

    public int getNumberOfAudioBooks() {
        return ((Number) em.createNamedQuery("Book.countAudio").getSingleResult()).intValue();

    }

    public int getNumberOfRecords() {
        return ((Number) em.createNamedQuery("Book.countAll").getSingleResult()).intValue();

    }
}





