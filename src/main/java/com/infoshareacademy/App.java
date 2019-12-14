package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class App {

    static List<MenuOption> newMenuList = new ArrayList<>();

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.populateMenu();
        // menu init

        menu.showMenu(Menu.MAIN_MENU_POSITION);

    }
}