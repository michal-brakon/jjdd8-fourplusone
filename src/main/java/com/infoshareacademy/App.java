package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        // read json file to collection

        stdout.info("Four-Plus-One");

        // menu init

        Menu menu = new Menu();
               menu.showMenu(Menu.MAIN_MENU_POSITION);

    }
}