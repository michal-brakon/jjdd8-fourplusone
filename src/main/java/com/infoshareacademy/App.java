package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    static List<MenuOption> newMenuList = new ArrayList<>();
private static Menu menu = new Menu() ;
    public static void main(String[] args) {
        MissingFileMenu missingFileMenu = new MissingFileMenu();
        Optional.ofNullable(BookRepository.getInstance().getBooks())
                .ifPresentOrElse(books -> {
                    stdout.info("Baza danych z książkami została załadowana\n");
                    menu.populateMenu();
                    menu.showMenu(Menu.MAIN_MENU_POSITION);
                }, missingFileMenu::showMenu);
    }
}