package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        // read json file to collection

        // menu init

        Menu menu = new Menu();
        menu.mainMenu();

        stdout.info("Four-Plus-One");

    }
}