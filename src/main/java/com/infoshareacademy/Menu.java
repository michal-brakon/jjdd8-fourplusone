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
        newMenuList.add(new MenuOptions("dostępne książki", 4, 1));
        newMenuList.add(new MenuOptions("Pokaż Wszystkie pozycje", 41, 4));
        newMenuList.add(new MenuOptions("Wyświetl jedna pozycje", 42, 4));

        while (position != 0) {
            ScreenCleaner.clearScreen();

            int parent = 0;


            // adding functionality on positions here

            if (position == 1) {

                stdout.info("Witamy na Glownej stronie biblioteki For Plus One");


            } else if (position == 41) {
                position = parent;
                new BookPrinter().printBooks(BookRepository.getInstance().getBookRepository());

            } else if (position==42){
                position = parent;
                int n = new BookPrinter().chooseBookToPrint();
                stdout.info(n + 1 + ". " + BookRepository.getInstance().getBookRepository().get(n));

            }

            parent = getParent(position, newMenuList, parent);
            position = printMenu(position, newMenuList, parent);

        }

    }

    private int printMenu(int position, List<MenuOptions> newMenuList, int parent) {
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
        return position;
    }

    private int getParent(int position, List<MenuOptions> newMenuList, int parent) {
        for (MenuOptions menuOptions : newMenuList) {
            if (menuOptions.getPosition() == position) {
                parent = menuOptions.getParent();
            }
        }
        return parent;
    }

}
