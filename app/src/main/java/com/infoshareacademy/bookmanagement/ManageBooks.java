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

    public void modifyAuthor(String author, Long id) {
        Book book = findBookById(id);
        book.setAuthor(author);
    }

    public void modifyTitle(String title, Long id) {
        Book book = findBookById(id);
        book.setTitle(title);
    }

    public void modifyKind(String kind, Long id) {
        Book book = findBookById(id);
        book.setKind(kind);
    }

    public void modifyGenre(String genre, Long id) {
        Book book = findBookById(id);
        book.setGenre(genre);
    }

    public void modifyEpoch(String epoch, Long id) {
        Book book = findBookById(id);
        book.setEpoch(epoch);
    }

    public void modifyHasAudio(boolean audio, Long id) {
        Book book = findBookById(id);
        book.setHasAudio(audio);
    }
}


