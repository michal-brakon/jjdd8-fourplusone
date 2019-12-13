package com.infoshareacademy;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookRepositoryTest {

    @Test
    public void test() {

        BookRepository repo = BookRepository.getInstance();

        List<Book> books = repo.findByAuthor("Homer");




//        Assertions.assertThat(books)
//                .extracting("author")
//                .containsOnly("Homer");


    }
}