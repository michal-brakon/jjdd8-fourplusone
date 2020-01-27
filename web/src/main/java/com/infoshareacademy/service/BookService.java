package com.infoshareacademy.service;

import com.infoshareacademy.dao.AuthorDao;
import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.mapper.BookMapper;
import com.infoshareacademy.mapper.view.BookMapperToView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Transactional
public class BookService {

    @Inject
    private BookDao bookDao;

    @Inject
    private AuthorDao authorDao;

    @Inject
    private BookMapper bookMapper;

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


    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public void addBooks(List<BookDTO> books) {

        books.forEach(this::addBook);
    }

    public void addBook(BookDTO bookDTO) {

        Book book = bookMapper.mapRequestToEntity(bookDTO);
        book.setAuthor(authorService.add(bookDTO.getAuthor()));
        book.setEpoch(epochService.add(bookDTO.getEpoch()));
        book.setKind(kindService.add(bookDTO.getKind()));
        book.setGenre(genreService.add(bookDTO.getGenre()));
        bookDao.addBook(book);
    }

    public Book getById(Long id) {
        return this.bookDao.findById(id).orElseThrow();
    }


    public List<BookView> findByTitle(String inputParam) {
        List<Book> bookList = bookDao.findByTitle(inputParam);
        return bookList.stream()
                .map(b -> bookMapperToView.mapEntityToView(b))
                .collect(Collectors.toList());
    }

    public BookView getBookViewById(Long id) {
        Book book = getById(id);
        return bookMapperToView.mapEntityToView(book);
    }

    public List<BookView> getBooksForPagination(int in) {

        List<Book> bbb = bookDao.getBooksForPagination(in);
        return bbb.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }




    public List<BookView> getAudioBooksForPagination(int in) {

        List<Book> bbb = bookDao.getAudioBooksForPagination(in);
        return bbb.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }

    public List<BookView> getEpicBooksForPagination(int in) {

        List<Book> bbb = bookDao.getEpicBooksForPagination(in);
        return bbb.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }

    public List<BookView> getDramaBooksForPagination(int in) {

        List<Book> bbb = bookDao.getDramacBooksForPagination(in);
        return bbb.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }

    public List<BookView> getLyricBooksForPagination(int in) {

        List<Book> bbb = bookDao.getLyricBooksForPagination(in);
        return bbb.stream().map(book -> bookMapperToView.mapEntityToView(book))
                .collect(Collectors.toList());

    }

}
