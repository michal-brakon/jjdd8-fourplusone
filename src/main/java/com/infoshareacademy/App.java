package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static Menu menu;

    public static void main(String[] args) {
        FileNotFindMenu fileNotFindMenu = new FileNotFindMenu();
        menu = new Menu();
        Optional.ofNullable( BookRepository.getInstance().getBooks())
                .ifPresentOrElse(books -> {
                    stdout.info("\nBaza json załadowana\n");
                    menu.mainMenu();
                }, fileNotFindMenu::showLoaderFileMenu);


    }

}