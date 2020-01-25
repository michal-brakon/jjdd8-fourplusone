package com.infoshareacademy.service;

import com.infoshareacademy.dao.GenreDao;
import com.infoshareacademy.domain.entity.Genre;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GenreService {

    @Inject
    private GenreDao genreDao;

    public Genre findOrAdd(String name) {

        Genre genre = genreDao.findGenreByName(name);
        if (genre == null) {
            genre = new Genre();
            genre.setName(name);
            genreDao.addGenre(genre);
        }
        return genre;
    }
}
