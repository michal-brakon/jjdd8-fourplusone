package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.mapper.view.BookMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AdminManagement {

    @Inject
    private BookMapperToView bookMapperToView;

    @Inject
    private BookDao bookDao;

    public BookView remove(Long id) {
        return bookMapperToView.mapEntityToView(bookDao.delete(id));
    }
}
//    public void update(Long bookId, BookDTO bookDTO) {
//
//
//        public void update (Long bookId, BookDTO bookDTO){
//            Book book = bookDao.findById(bookId);
//
//            Author author = authorDao.findAuthorByName(bookDTO.getAuthor());
//            book.setAuthor(author);
//
//            String[] authorsNames;
//            List<Author> authors = new ArrayList<>();
//
//            String authorName = bookDTO.getAuthor();
//
//            authorsNames = authorName.split(",");
//
//            Arrays.stream(authorsNames)
//                    .forEach(a -> authors.add(authorService.findOrAdd(a.trim()))
//                    );
//
//            String kindName = book.getKind().getName();
//            LiteratureKind kind = kindService.findOrAdd(kindName);
//
//            String epochName = bookDTO.getEpoch();
//            Epoch epoch = epochService.findOrAdd(epochName);
//
//            String genreName = bookDTO.getGenre();
//            Genre genre = genreService.findOrAdd(genreName);
//
//
//            authors.forEach(book::setAuthor);
//            book.setKind(kind);
//            book.setEpoch(epoch);
//            book.setGenre(genre);
//            book.setTitle(bookDTO.getTitle());
//            book.setCover(bookDTO.getCover());
//            book.setCoverThumb(bookDTO.getCoverThumb());
//            book.setSimpleThumb(bookDTO.getSimpleThumb());
//            book.setHasAudio(bookDTO.getHasAudio());
//
//            bookDao.update(book);
//        }
//    }