package com.infoshareacademy.mapper.view;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class BookMapperToView {

    private static final Logger logger = LoggerFactory.getLogger(BookMapperToView.class.getName());

    @Transactional
    public BookView mapEntityToView(Book book) {

        BookView view = new BookView();
        view.setAudio(book.getHasAudio());
        view.setCover(book.getCover());
        view.setTitle(book.getTitle());
//        logger.info("tytuł" + book.getTitle());
        view.setAuthor(book.getAuthor().getName());
        view.setEpoch(book.getEpochId().getName());
        view.setGenre(book.getGenre().getName());
        view.setKind(book.getKind().getName());
        view.setId(book.getId());
        view.setCover_thumb(book.getCoverThumb());

        return view;
    }
}
