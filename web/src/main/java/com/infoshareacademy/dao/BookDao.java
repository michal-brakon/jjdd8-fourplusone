package com.infoshareacademy.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class SingleBookDao {
@PersistenceContext

    private EntityManager em;

    public Book getById(Long id) {
        return em.find(Book.class, id);}
}
