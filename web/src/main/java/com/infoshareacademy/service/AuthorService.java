package com.infoshareacademy.service;

import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.view.AuthorView;
import com.infoshareacademy.mapper.view.AuthorMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class AuthorService {

    @Inject
    private AuthorDao authorDao;

    @Inject
    private AuthorMapperToView authorMapperToView;

    public Author add(String name) {

        return Optional.ofNullable(authorDao.findAuthorByName(name)).orElseGet(() -> {
            Author author = new Author();
            author.setName(name);
            authorDao.addAuthor(author);
            return author;
        });
    }

    public List<AuthorView>     authorNameLiveSearch(String param) {
        List<Author> authorList = authorDao.forLiveSearch(param);
        return authorList.stream()
                .map(b -> authorMapperToView.mapEntityToRequest(b))
                .collect(Collectors.toList());
    }

    public List<AuthorView> getAll() {
        List<AuthorView> authorViews = new ArrayList<>();
        authorDao.getAll().forEach(epoch -> {
            AuthorView authorView = authorMapperToView.mapEntityToRequest(epoch);
            authorViews.add(authorView);
        });
        return authorViews;
    }

}
