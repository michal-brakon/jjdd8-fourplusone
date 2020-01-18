package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Pagination {

    @Inject
    BookDao bookDao;

    public List<List<Book>> paginate(List<Long> ids) {


        int counter = 0;
        int counter2 = 0;
        List<Book> listBook = new ArrayList<>();
        List<List<Book>> duzaLista = new ArrayList<>();

        while (counter2 < ids.size() / 21) {
            while (counter < counter2 * 21 || counter >= ids.size()) {
                bookDao.findById(ids.get(counter));
                listBook.add(bookDao.findById(ids.get(counter)));
                counter++;
            }
            counter2++;
            duzaLista.add(listBook);

        }
        return duzaLista;
    }
}
