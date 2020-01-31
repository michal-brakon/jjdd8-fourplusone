package com.infoshareacademy.service;

import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.domain.entity.Author;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Stateless
public class AuthorService {

    @Inject
    private AuthorDao authorDao;

    public Author add(String name) {

        return Optional.ofNullable(authorDao.findAuthorByName(name)).orElseGet(() -> {
            Author author = new Author();
            author.setName(name);
            authorDao.addAuthor(author);
            return author;
        });
    }
    public List<AuthorView> getAll(){

    }
 }
