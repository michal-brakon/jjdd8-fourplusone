package com.infoshareacademy.service;

import com.infoshareacademy.dao.EpochDao;
import com.infoshareacademy.dao.GenreDao;
import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.entity.Genre;

import javax.inject.Inject;

public class GenreService {

    @Inject
    private GenreDao genreDao;

    public Genre findOrAdd(String name)  {

        Genre genre = genreDao.findGenreByName(name);
        if (genre == null)  {
            Genre newGenre = new Genre();
            genreDao.addGenre(newGenre);
            return newGenre;
        }
        return genre;
    }
}
