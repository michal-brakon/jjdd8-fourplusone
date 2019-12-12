package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        // load file
        // if file does not exist, show exception menu
        // else run main menu
//        // menu init
        Menu menu = new Menu();
        menu.mainMenu();
//
//        String a = "fasfafsaf";
//
//        Optional.ofNullable(a).ifPresentOrElse(System.out::println, () -> {System.out.println("aaa");});


    }
}