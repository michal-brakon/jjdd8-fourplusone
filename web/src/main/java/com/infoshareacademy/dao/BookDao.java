package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class BookDao {

    private final int BOOK_LIMIT = 20;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public Long addBook(Book book) {
        em.persist(book);
        logger.info("New book was added :{}", book);
        return book.getId();
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    public List<Book> findAll() {
        Query query = em.createNamedQuery("Book.findAll");
        return query.getResultList();
    }

    public List<Book> findByTitle(String inputParam) {
        Query query = em.createNamedQuery("Book.findByTitle");
        query.setParameter("inputParam", "%" + inputParam + "%");
        return query.setMaxResults(5).getResultList();}

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
        return query.getResultList();   }

    public List<Book> getAudioBooksForPagination(int in) {
        Query query = em.createNamedQuery("Book.findAudioBooks");
        query.setFirstResult(in);
        query.setMaxResults(BOOK_LIMIT);
        return query.getResultList();
    }

    public List<Book> getEpicBooksForPagination(int in) {
        Query query = em.createNamedQuery("Book.findEpic");
        query.setFirstResult(in);
        query.setMaxResults(BOOK_LIMIT);
        return query.getResultList();
    }

    public List<Book> getLyricBooksForPagination(int in) {
        Query query = em.createNamedQuery("Book.findLyric");
        query.setFirstResult(in);
        query.setMaxResults(BOOK_LIMIT);
        return query.getResultList();
    }

    public List<Book> getDramacBooksForPagination(int in) {
        Query query = em.createNamedQuery("Book.findDrama");
        query.setFirstResult(in);
        query.setMaxResults(BOOK_LIMIT);
        return query.getResultList();
    }

    public int getNumberOfEpicBooks() {
        return ((Number) em.createNamedQuery("Book.countEpic").getSingleResult()).intValue();
    }

    public int getNumberOfLyricBooks() {
        return ((Number) em.createNamedQuery("Book.countLyric").getSingleResult()).intValue();
    }

    public int getNumberOfDramaBooks() {
        return ((Number) em.createNamedQuery("Book.countDrama").getSingleResult()).intValue();
    }

    public int getNumberOfAudioBooks() {
        return ((Number) em.createNamedQuery("Book.countAudio").getSingleResult()).intValue();
    }

    public int getNumberOfRecords() {
        return ((Number) em.createNamedQuery("Book.countAll").getSingleResult()).intValue();
    }


    public void update(Book book) {
        em.merge(book);
        logger.info("Book has been update {}", book);
    }


    public Book delete(Long id) {
        Book book = findById(id).orElseThrow();
        em.remove(book);
        return book;
    }
}