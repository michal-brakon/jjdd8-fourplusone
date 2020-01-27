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
            Author author1 = new Author();
            author1.setName(name);
            authorDao.addAuthor(author1);
            return author1;
        });
    }
}
