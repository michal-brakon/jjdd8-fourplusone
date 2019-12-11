package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;




public class Menu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    protected static final int MAIN_MENU_POSITION = 1;
    protected static final int BOOK_MENU_POSITION = 4;
    protected static final int EXIT_POSITION = 0;
    protected static final int SHOW_ALL_BOOKS_POSITION = 41;
    protected static final int SHOW_ONE_BOOK_POSITION = 42;
    protected static final int MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE = 10;
    UserInput getNumber = new UserInput();

    public void showMenu(int position) {



        List<MenuOption> newMenuList = new ArrayList<>();
        newMenuList.add(new MenuOption("głowne menu", MAIN_MENU_POSITION, EXIT_POSITION));
        newMenuList.add(new MenuOption("dostępne książki", BOOK_MENU_POSITION, MAIN_MENU_POSITION));
        newMenuList.add(new MenuOption("Pokaż Wszystkie pozycje", SHOW_ALL_BOOKS_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyświetl jedną pozycję", SHOW_ONE_BOOK_POSITION, BOOK_MENU_POSITION));

        while (position != EXIT_POSITION) {
            ScreenCleaner.clearScreen();

            int parent = 0;


            // adding functionality on positions here


            if (position == MAIN_MENU_POSITION) {


                stdout.info("Witamy na Głównej stronie biblioteki 'For Plus One'");


            } else if (position == SHOW_ALL_BOOKS_POSITION) {
                position = parent;
                new BookPrinter().printBooks(BookRepository.getInstance().getBookRepository());

            } else if (position==SHOW_ONE_BOOK_POSITION){
                position = parent;
                new BookPrinter().getOneBook();
            }

            parent = getParent(position, newMenuList, parent);
            position = printMenu(position, newMenuList, parent);


        }

    }

    private int printMenu(int position, List<MenuOption> newMenuList, int parent) {
        stdout.info("Masz do wyboru:");
        int[] choicesNumber = new int[MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE];
        int pressNumber = 1;
        for (MenuOption menuOption : newMenuList) {

            if (menuOption.getParent() == position) {

                stdout.info("\n" + pressNumber + "<-  " + menuOption.getDisplayedText());

                choicesNumber[pressNumber] = menuOption.getPosition();
                pressNumber++;
            }

        }
        stdout.info("\n0<-  wróć do poprzedniego menu  ");
        stdout.info("\n wybierz numer opcji z menu: ");
        int userChoice = getNumber.getChoice(pressNumber - 1);
        stdout.info("\nwybraleś " + userChoice + " \n");
        if (userChoice != 0) {
            position = choicesNumber[userChoice];

        } else {
            position = parent;

        }
        return position;
    }

    private int getParent(int position, List<MenuOption> newMenuList, int parent) {
        for (MenuOption menuOption : newMenuList) {
            if (menuOption.getPosition() == position) {
                parent = menuOption.getParent();
            }
        }
        return parent;
    }

}

