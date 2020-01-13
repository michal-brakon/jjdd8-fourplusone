package com.infoshareacademy;

import com.infoshareacademy.dao.AuthorDao;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookRelation {

    @Inject
    private AuthorDao authorDao;

    public void setRelation() {


    }
}
