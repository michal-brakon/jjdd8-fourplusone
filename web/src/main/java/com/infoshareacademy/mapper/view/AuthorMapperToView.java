package com.infoshareacademy.mapper.view;

import com.infoshareacademy.domain.entity.Author;
import com.infoshareacademy.domain.view.AuthorView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AuthorMapperToView {

    public AuthorView mapEntityToRequest(Author author) {
        AuthorView authorView = new AuthorView();
        authorView.setId(author.getId());
        authorView.setName(author.getName());
        return authorView;
    }
}
