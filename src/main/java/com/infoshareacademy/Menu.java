package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Menu {
    protected static final int MAIN_MENU_POSITION = 1;
    protected static final int BOOK_MENU_POSITION = 4;
    protected static final int EXIT_POSITION = 0;
    protected static final int SHOW_ALL_BOOKS_POSITION = 41;
    protected static final int SHOW_ONE_BOOK_POSITION = 42;
    protected static final int MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE = 10;
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();

    public void showMenu(int position) {


        while (position != EXIT_POSITION) {
            ScreenCleaner.clearScreen();

            // adding functionality on positions here from this point
            if (position == MAIN_MENU_POSITION) {

                stdout.info("Witamy na Głównej stronie biblioteki 'For Plus One'");

            } else if (position == SHOW_ALL_BOOKS_POSITION) {

                new BookPrinter().printBooks(BookRepository.getInstance().getBookRepository());
                break;

            } else if (position == SHOW_ONE_BOOK_POSITION) {
                new BookPrinter().getOneBook();
                break;
            }

            menuBreadcrumbs(position);

            position = printMenu(position);
        }
    }

    private int printMenu(int position) {
        stdout.info("Masz do wyboru:");
        int[] choicesNumber = new int[MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE];
        int pressNumber = 1;
        for (MenuOption menuOption : App.newMenuList) {

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

            position = getParentFromList(position);
        }
        return position;
    }

    private void menuBreadcrumbs(int position) {
        int currentIndex = 0;
        String crumbs = "";
        int crumbPosition = position;
        while (crumbPosition != MAIN_MENU_POSITION) {
            currentIndex = getIndexFromList(crumbPosition);
            crumbs = App.newMenuList.get(currentIndex).getDisplayedText() + " / " + crumbs;
            crumbPosition = App.newMenuList.get(currentIndex).getParent();
        }
        stdout.info("\nGlowne Menu " + crumbs + "\n");
    }

    private int getIndexFromList(int position) {
        int currentMenuIndex = 0;
        for (int i = 0; i < App.newMenuList.size(); i++) {
            if (App.newMenuList.get(i).getPosition() == position) {
                currentMenuIndex = i;
                return currentMenuIndex;
            }
        }
        return currentMenuIndex;
    }

    private int getParentFromList(int position) {
        int parent = 0;

        for (int i = 0; i < App.newMenuList.size(); i++) {
            if (position == App.newMenuList.get(i).getPosition()) {
                App.newMenuList.get(i).getParent();
                return parent;
            }
        }
        return parent;
    }

}

