package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Book;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.View;

@Stateless
@Local
public class BookDao {
@PersistenceContext

    private EntityManager em;

    public Book getById(Long id) {return em.find(Book.class, id);}
}
