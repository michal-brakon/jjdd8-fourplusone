package com.infoshareacademy.service;

import com.infoshareacademy.dao.GenreDao;
import com.infoshareacademy.domain.entity.Genre;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Stateless
public class GenreService {

    @Inject
    private GenreDao genreDao;

    public Genre add(String name) {

        return Optional.ofNullable(genreDao.findGenreByName(name)).orElseGet(() -> {
            Genre genre = new Genre();
            genre.setName(name);
            genreDao.addGenre(genre);
            return genre;
        });
    }
}
