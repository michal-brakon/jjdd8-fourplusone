package com.infoshareacademy.service;


import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.dao.BookDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class StatisticService {

    @Inject
    BookDao bookDao;

    @Inject
    AuthorDao authorDao;

    public Map<String, Integer> getReservationCounters(Long bookId, String authorName) {
        int bookReservationCounter = bookDao.getReservationCounter(bookId);
        int authorReservationCounter = authorDao.getReservationCounter(authorName);

        Map <String, Integer> result = new HashMap<>();
        result.put("book", bookReservationCounter);
        result.put("author", authorReservationCounter);
        return result;
    }
}
