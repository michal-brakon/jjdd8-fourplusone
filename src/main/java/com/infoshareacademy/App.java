package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static Menu menu;

    public static void main(String[] args) {
        JsonFileMissingMenu fileMissingMenu = new JsonFileMissingMenu();
        menu = new Menu();
        Optional.ofNullable( BookRepository.getInstance().getBooks())
                .ifPresentOrElse(books -> {
                    stdout.info("\nBaza json załadowana\n");
                    menu.mainMenu();
                }, fileMissingMenu::showLoaderFileMenu);


    }

}