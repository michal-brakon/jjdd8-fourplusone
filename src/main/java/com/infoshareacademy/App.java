package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        // read json file to collection
        BookParser bookParser = new BookParser();
        bookParser.parseJsonFileToObject();

        stdout.info("Four-Plus-One");

        stdout.info("\n Rozmiar listy: " + BookRepository.getBooks().size());

        // menu init

        Menu menu = new Menu();
        menu.mainMenu();



    }
}