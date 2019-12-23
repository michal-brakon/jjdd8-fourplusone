package com.infoshareacademy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookSorterTest {

    @Test
    void shouldReturnedListOfBooksSortedByTitle() {

        BookSorter bookSorter = new BookSorter();
        List<Book> listForTest = BookRepository.getInstance().getBooks();
        assertEquals('A', bookSorter.sortingByTitle(listForTest).get(0).getTitle().charAt(0));
    }
}
