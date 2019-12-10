package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        // read json file to collection
        BookParser bookParser = new BookParser();
        bookParser.parseJsonFileToObject();


        Menu menu = new Menu();
               menu.showMenu(1);

        stdout.info("\nFour-Plus-One");

    }
}