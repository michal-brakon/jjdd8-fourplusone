package com.infoshareacademy.service;

import com.infoshareacademy.dao.RatingDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.Rating;
import com.infoshareacademy.domain.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

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

    public boolean checkIsRated (User user, Book book) {

       // boolean isRated = false;

//        if (ratingDao.findRatingByBook(book).isPresent()) {
//            if (ratingDao.findRatingByBook(book).get().getUser() == user) {
//                isRated = true;
//            }
//        }
//        return isRated;

        Boolean isRated = ratingDao
                .findRatingByBook(book)
                .filter(rating -> rating.getUser() == user)
                .map(rating -> {
                    if (rating.getUser() == user) {
                        return true;
                    }  else {
                        return false;
                    }
                })
                .orElse(false);

        return isRated;
    }
}

