package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }

    public User findUserByEmail(String email) {

        Query query = em.createNamedQuery("User.findByEmail");
        query.setParameter("email", email);

        List<User> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
        }


//        ???

    public User findById(Long id) {
        Query query = em.createNamedQuery("User.getById");
        query.setParameter("id", id);
        return (User) query.getResultList().get(0);
    }

    }

