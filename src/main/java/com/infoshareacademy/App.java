package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    protected static final int MAIN_MENU_POSITION = 1;

    public static void main(String[] args) {

        // read json file to collection

        stdout.info("Four-Plus-One");

        // menu init

        Menu menu = new Menu();
               menu.showMenu(MAIN_MENU_POSITION);

    }
}