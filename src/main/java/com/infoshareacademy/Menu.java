package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();


    public void showMenu(int position) {


        List<MenuOptions> newMenuList = new ArrayList<>();
        newMenuList.add(new MenuOptions("glowne menu", 1, 0));
        newMenuList.add(new MenuOptions("test menu", 2, 1));
        newMenuList.add(new MenuOptions("another test menu", 2, 1));
        newMenuList.add(new MenuOptions("dostępne książki", 4, 1));
        newMenuList.add(new MenuOptions("last test menu", 5, 1));
        newMenuList.add(new MenuOptions("Pokaż Wszystkie pozycje", 41, 4));
        newMenuList.add(new MenuOptions("secret menu number four", 42, 4));


        while (position != 0) {
            stdout.info("\033[H\033[2J");
            stdout.info("\n");

            int parent = 0;
            for (MenuOptions menuOptions : newMenuList) {
                if (menuOptions.getPosition() == position) {
                    parent = menuOptions.getParent();
                }
            }

            // adding functionality on positions here
            if (position == 1) {

                stdout.info("Witamy na Glownej stronie biblioteki For Plus One");


            } else if (position == 41) {
                position = parent;
                new BookPrinter().printBooks(BookRepository.getBooks());


            }


            stdout.info("Masz do wyboru:");
            int[] choicesNumber = new int[10];
            int pressNumber = 1;
            for (MenuOptions menuOptions : newMenuList) {

                if (menuOptions.getParent() == position) {

                    stdout.info("\n" + pressNumber + "<-  " + menuOptions.getDisplayedText());

                    choicesNumber[pressNumber] = menuOptions.getPosition();
                    pressNumber++;
                }

            }
            stdout.info("\n0<-  wróć do poprzedniego menu  ");
            stdout.info("\n wybierz numer opcji z menu: ");
            int userChoice = getNumber.getChoice(pressNumber - 1);
            stdout.info("\nwybrales " + userChoice + " \n");
            if (userChoice != 0) {
                position = choicesNumber[userChoice];

            } else {
                position = parent;

            }


        }

    }

}
