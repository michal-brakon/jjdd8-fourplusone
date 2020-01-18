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

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addBook(Book book) {

        em.persist(book);
        logger.info("New book was added :{}", book);

    }
    public Book findById(Long id){

        Query query = em.createNamedQuery("Book.getById");
        query.setParameter("id",id);
        return (Book)query.getSingleResult();
    }

    public List<Book> findAll() {
          Query query=em.createNamedQuery("Book.findAll");

    return  query.getResultList();

    }

    public List<Book> getBooksForPagination (int start, int end) {
        Query ids = em.createNamedQuery("Book.getId");
        List<Integer> booksIds = ids.getResultList();
        Query query = em.createNamedQuery("Books.details");

        query.setParameter("ids", booksIds.subList(start,end));
        return query.getResultList();
    }
}





