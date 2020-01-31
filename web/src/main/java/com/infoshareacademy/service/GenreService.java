package com.infoshareacademy.service;

import com.infoshareacademy.dao.GenreDao;
import com.infoshareacademy.domain.entity.Genre;
import com.infoshareacademy.domain.view.GenreView;
import com.infoshareacademy.mapper.view.GenreMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class GenreService {

    @Inject
    private GenreDao genreDao;
    @Inject
    private GenreMapperToView genreMapperToView;

    public Genre add(String name) {

        return Optional.ofNullable(genreDao.findGenreByName(name)).orElseGet(() -> {
            Genre genre = new Genre();
            genre.setName(name);
            genreDao.addGenre(genre);
            return genre;
        });
    }

    public List<GenreView> getAll() {
        List<GenreView> genreViews = new ArrayList<>();
        genreDao.getAll().forEach(genre -> {
            GenreView genreView = genreMapperToView.mapEntityToRequest(genre);
            genreViews.add(genreView);
        });
        return genreViews;
    }
}
