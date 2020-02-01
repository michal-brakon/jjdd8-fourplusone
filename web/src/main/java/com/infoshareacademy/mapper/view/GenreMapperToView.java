package com.infoshareacademy.mapper.view;

import com.infoshareacademy.domain.entity.Genre;
import com.infoshareacademy.domain.view.GenreView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GenreMapperToView {

    public GenreView mapEntityToRequest(Genre genre) {
        GenreView genreView = new GenreView();
        genreView.setId(genre.getId());
        genreView.setName(genre.getName());
        return genreView;
    }
}
