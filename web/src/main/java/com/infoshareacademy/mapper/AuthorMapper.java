package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.AuthorJson;
import com.infoshareacademy.domain.entity.Author;

import javax.ejb.Stateless;

@Stateless
public class AuthorMapper{


    public Author mapApiRequestToEntity(AuthorJson authorJson) {

        Author author = new Author();
        author.setName(authorJson.getName());
        return author;
    }
}
