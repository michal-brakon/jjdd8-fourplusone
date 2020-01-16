package com.infoshareacademy.service;

import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.domain.entity.Author;

import javax.inject.Inject;

public class AuthorService {

    @Inject
    private AuthorDao authorDao;

    public Author findOrAdd(String name)  {

        Author author = authorDao.findAuthorByName(name);
        if (author == null)  {
            Author newAuthor = new Author();
            authorDao.addAuthor(newAuthor);
            return newAuthor;
        }
        return author;
    }
}
