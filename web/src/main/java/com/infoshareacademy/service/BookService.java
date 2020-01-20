package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.*;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.mapper.view.BookMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class BookService {

    @Inject
    private BookDao bookDao;

    @Inject
    private BookMapperToView bookMapperToView;

    @Inject
    private AuthorService authorService;

    @Inject
    private KindService kindService;

    @Inject
    private EpochService epochService;

    @Inject
    private GenreService genreService;


    public void addBooks (List<BookDTO> books)  {

        books
                .forEach(this::addBook);
    }
    public void addBook(BookDTO book) {

        String authorName = book.getAuthor();
        Author author = authorService.findOrAdd(authorName);

        String kindName = book.getKind();
        LiteratureKind kind = kindService.findOrAdd(kindName);

        String epochName = book.getEpoch();
        Epoch epoch = epochService.findOrAdd(epochName);

        String genreName = book.getGenre();
        Genre genre = genreService.findOrAdd(genreName);

        Book bookDaoToEntity = new Book();

        bookDaoToEntity.setAuthor(author);
        bookDaoToEntity.setKind(kind);
        bookDaoToEntity.setEpoch(epoch);
        bookDaoToEntity.setGenre(genre);
        bookDaoToEntity.setTitle(book.getTitle());
        bookDaoToEntity.setCover(book.getCover());
        bookDaoToEntity.setCoverThumb(book.getCoverThumb());
        bookDaoToEntity.setSimpleThumb(book.getSimpleThumb());
        bookDaoToEntity.setHasAudio(book.getHasAudio());

        bookDao.addBook(bookDaoToEntity);
    }


    public Book getById(Long id) {
        return this.bookDao.findById(id);
    }


    @Transactional
    public List<BookView> findByTitle(String inputParam){
         List<Book> bookList = bookDao.findByTitle(inputParam);
           return bookList.stream()
                   .map(b -> bookMapperToView.mapEntityToView(b))
                   .collect(Collectors.toList());
          }

    @Transactional
    public BookView getBookViewById(Long id) {
        Book book = getById(id);
        return bookMapperToView.mapEntityToView(book);
    }

    @Transactional
    public List<BookView> getAllBooksView() {
        List<Book> bookViews = bookDao.findAll();
        return bookViews.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<BookView> booksForPagination() {

        List<Book> booksPagination = bookDao.getBooksForPagination();
        return booksPagination.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }
    @Transactional
   public List<BookView> books333(int in) {

        List<Book> bbb = bookDao.get333(in);
        return bbb.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }

}
