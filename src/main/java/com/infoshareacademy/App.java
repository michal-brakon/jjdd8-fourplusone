package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    static List<MenuOption> newMenuList = new ArrayList<>();

    public static void main(String[] args) {

        Menu menu = new Menu();
        newMenuList.add(new MenuOption("Głowne menu", menu.MAIN_MENU_POSITION, menu.EXIT_POSITION));
        newMenuList.add(new MenuOption("Dostępne książki", menu.BOOK_MENU_POSITION, menu.MAIN_MENU_POSITION));
        newMenuList.add(new MenuOption("Pokaż Wszystkie pozycje", menu.SHOW_ALL_BOOKS_POSITION, menu.BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyświetl jedną pozycję", menu.SHOW_ONE_BOOK_POSITION, menu.BOOK_MENU_POSITION));
        // menu init

        menu.showMenu(menu.MAIN_MENU_POSITION);

    }
}