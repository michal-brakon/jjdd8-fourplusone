package com.infoshareacademy.mapper.view;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.service.UrlBuilderService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
public class BookMapperToView {

    @Inject
    private UrlBuilderService urlBuilderService;

    @Transactional
    public BookView mapEntityToView(Book book) {

        BookView view = new BookView();
        view.setAudio(book.getHasAudio());
        view.setCover(book.getCover());
        view.setTitle(book.getTitle());
        view.setAuthor(book.getAuthor().getName());
        view.setEpoch(book.getEpochId().getName());
        view.setGenre(book.getGenre().getName());
        view.setKind(book.getKind().getName());
        view.setId(book.getId());
        if (book.getCover() != null && book.getCover().contains("book/")) {
            view.setCover(urlBuilderService.buildApiImagesUrlForFile(book.getCover()));
            view.setCoverThumb(urlBuilderService.buildApiImagesUrlForFile(book.getCoverThumb()));
        } else if (book.getCover() == null || book.getCover().isEmpty()) {
            view.setCover(urlBuilderService.buildBaseUrlForFile("html/img/missing.jpg"));
            view.setCoverThumb(urlBuilderService.buildBaseUrlForFile("html/img/missing.jpg"));
        } else {
            view.setCover(urlBuilderService.buildImagesUrlForFile(book.getCover()));
            view.setCoverThumb(urlBuilderService.buildImagesUrlForFile(book.getCoverThumb()));
        }
        return view;
    }
}
