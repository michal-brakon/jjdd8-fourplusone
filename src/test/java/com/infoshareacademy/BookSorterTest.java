package com.infoshareacademy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookSorterTest {

    @Test
    void shouldReturnedListOfBooksSortedByTitle() {

        BookSorter bookSorter = new BookSorter();
        List<Book> listForTest = BookRepository.getInstance().getBooks();
        Assertions.assertEquals('A', bookSorter.sortingByTitle(listForTest).get(0).getTitle().charAt(0));
    }
}
