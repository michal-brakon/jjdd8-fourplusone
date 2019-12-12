package com.infoshareacademy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookSorterTest {

    @Test
    public void shouldReturnedListOfBooksSortedByTitle() {

        BookSorter bookSorter = new BookSorter();
        List<Book> listForTest = BookRepository.getInstance().getBooks();
        Assertions.assertEquals('A', bookSorter.sortingByTitle(listForTest).get(0).getTitle().charAt(0));
    }

//    @Test
//    public void shouldReturnedListOfBooksSortedByKind() {
//
//        BookSorter bookSorter = new BookSorter();
//        List<Book> listForTest = BookRepository.getInstance().getBooks();
//        Assertions.assertEquals('A', bookSorter.sortingByKind(listForTest).get(0).getTitle().charAt(0));
//    }
//
//    @Test
//    public void shouldReturnedListOfBooksSortedByAuthor() {
//
//        BookSorter bookSorter = new BookSorter();
//        List<Book> listForTest = BookRepository.getInstance().getBooks();
//        Assertions.assertEquals('A', bookSorter.sortingByAuthor(listForTest).get(0).getTitle().charAt(0));
//    }
//
//    @Test
//    public void shouldReturnedListOfBooksSortedByEpoch() {
//
//        BookSorter bookSorter = new BookSorter();
//        List<Book> listForTest = BookRepository.getInstance().getBooks();
//        Assertions.assertEquals('A', bookSorter.sortingByEpoch(listForTest).get(0).getTitle().charAt(0));
//    }
//
//    @Test
//    public void shouldReturnedListOfBooksSortedByGenre() {
//
//        BookSorter bookSorter = new BookSorter();
//        List<Book> listForTest = BookRepository.getInstance().getBooks();
//        Assertions.assertEquals('A', bookSorter.sortingByGenre(listForTest).get(0).getTitle().charAt(0));
//    }
}
