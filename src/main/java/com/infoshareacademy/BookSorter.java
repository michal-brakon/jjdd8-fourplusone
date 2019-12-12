package com.infoshareacademy;
import org.apache.logging.log4j.util.PropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class BookSorter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

            List<Book> toSort = BookRepository.getInstance().getBookRepository();

            List<Book> sorting (List toSort) {

             List<Book> tralalala = toSort.stream()
                     .sorted )





//                         .sorted(Comparator.comparing(Book::getEpoch))
//                         .collect(Collectors.toList());


                return tralalala;
            }


    @Override
    public String toString() {
        return "BookSorter{" +
                "toSort=" + toSort +
                '}';
    }

    public static void main(String[] args) {
        BookSorter jaja = new BookSorter();

        System.out.println(jaja.toSort);
    }



}










