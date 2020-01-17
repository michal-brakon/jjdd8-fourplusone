package com.infoshareacademy.service;

import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.domain.entity.Author;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AuthorService {

    @Inject
    private AuthorDao authorDao;

    public Author findOrAdd(String name) {

        Author author = authorDao.findAuthorByName(name);
        if (author == null) {
            Author newAuthor = new Author();
            newAuthor.setName(name);
            authorDao.addAuthor(newAuthor);
            System.out.println("New author added: " + newAuthor.getName());
            return newAuthor;
        }
        System.out.println("Author added: " + author.getName());
        return author;

    }
}
