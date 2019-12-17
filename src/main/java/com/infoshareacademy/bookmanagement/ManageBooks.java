package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.BookRepository;

import java.util.concurrent.atomic.AtomicReference;

public class ManageBooks {

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
}


