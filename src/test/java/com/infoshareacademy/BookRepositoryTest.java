package com.infoshareacademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookRepositoryTest {

    @Test
    @DisplayName("Should contains only one author")
    public void should_find_only_one_author() {

        BookRepository repo = BookRepository.getInstance();
        List<Book> books = repo.findByAuthor("Homer");
        Assertions.assertThat(books)
                .extracting("author")
                .containsOnly("Homer");
    }
}