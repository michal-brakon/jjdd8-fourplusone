package com.infoshareacademy.service;

import com.infoshareacademy.dao.UserDao;
import com.infoshareacademy.domain.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService {

    @EJB
    UserDao userDao;

    public User getById(Long id) {
        return userDao.findById(id);
    }
}
