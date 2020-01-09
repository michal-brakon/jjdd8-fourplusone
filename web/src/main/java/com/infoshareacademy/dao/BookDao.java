package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Book;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class BookDao {
@PersistenceContext

    private EntityManager em;

    public Book getById(Long id) {return em.find(Book.class, id);}
}
