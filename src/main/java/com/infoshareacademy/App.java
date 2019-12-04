package com.infoshareacademy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        // read json file to collection
        new BookParser().parseJsonFileToObject();

        // create target books collection
        BookRepository.getBooks();


        for (Book book : BookRepository.bookRepository) {
            System.out.println(book);
        }


        // et voila
    }
}


