package com.infoshareacademy.service;

import com.infoshareacademy.dao.RatingDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Rating;
import com.infoshareacademy.domain.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RatingService {

    @Inject
    private RatingDao ratingDao;

    public void addRating (User user, Book book, Long scores)  {
        Rating rating = new Rating();

        rating.setBook(book);
        rating.setUser(user);
        rating.setScores(scores);

        ratingDao.addRating(rating);
    }

    public void checkIsRated (User user, Book book)  {

    }
}
