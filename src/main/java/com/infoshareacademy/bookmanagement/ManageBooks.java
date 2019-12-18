package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;

import java.util.concurrent.atomic.AtomicReference;

public class ManageBooks {


    public Book findBookById(Long id) {
        return BookRepository.getInstance().getBooks().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void assignIdsToBookRepository() {
        BookRepository.getInstance().getBooks().forEach(book -> {
            if (book.getId() == null) {
                book.setId(getSequenceId());
            }
        });
    }

    public Long getSequenceId() {
        AtomicReference<Long> maxId = new AtomicReference<>(0L);
        BookRepository.getInstance().getBooks().forEach(book -> {
            if (book.getId() != null && book.getId() > maxId.get()) {
                maxId.set(book.getId());
            }
        });
        return maxId.get() + 1;
    }

    public void modifiesByAuthor(String author, Long id) {
        Book book = findBookById(id);
        book.setAuthor(author);
    }

    public void modifiesByTitle(String title, Long id) {
        Book book = findBookById(id);
        book.setAuthor(title);
    }

    public void modifiesByKind(String kind, Long id) {
        Book book = findBookById(id);
        book.setKind(kind);
    }

    public void modifiesByGenre(String genre, Long id) {
        Book book = findBookById(id);
        book.setGenre(genre);
    }

    public void modifiesByEpoch(String epoch, Long id) {
        Book book = findBookById(id);
        book.setEpoch(epoch);
    }

    public void modifiesByHasAudio(Long id) {
        Book book = findBookById(id);
        BookAdder bookAdder = new BookAdder();
       boolean audio =  bookAdder.audioChanger();
       book.setHasAudio(audio);
    }
}


