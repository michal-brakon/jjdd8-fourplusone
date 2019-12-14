package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshareacademy.App.newMenuList;

public class Menu {

    protected static final int SEARCH_BY_AUTHOR_POSITION = 6;
    protected static final int SEARCH_BY_TITLE_POSITION = 7;
    protected static final int SEARCH_BY_AUTHOR_OR_TITLE = 8;
    protected static final int MAIN_MENU_POSITION = 1;
    protected static final int BOOK_MENU_POSITION = 2;
    protected static final int EXIT_POSITION = 0;
    protected static final int SHOW_ALL_BOOKS_POSITION = 3;
    protected static final int SHOW_ONE_BOOK_POSITION = 4;
    protected static final int MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE = 5;

    public void populateMenu() {

        newMenuList.add(new MenuOption("Głowne menu", MAIN_MENU_POSITION, EXIT_POSITION));
        newMenuList.add(new MenuOption("Dostępne książki", BOOK_MENU_POSITION, MAIN_MENU_POSITION));
        newMenuList.add(new MenuOption("Pokaż Wszystkie pozycje", SHOW_ALL_BOOKS_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyświetl jedną pozycję", SHOW_ONE_BOOK_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po autorze", SEARCH_BY_AUTHOR_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po tytule", SEARCH_BY_TITLE_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po autorze  tytule", SEARCH_BY_AUTHOR_OR_TITLE, SHOW_ONE_BOOK_POSITION));

    }


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();

    public void showMenu(int position) {

        while (position != EXIT_POSITION) {
            ScreenCleaner.clearScreen();
            Header.headerPrinter();
            // adding functionality on positions here from this point
            if (position == MAIN_MENU_POSITION) {

                stdout.info("\nWitamy na Głównej stronie biblioteki 'For Plus One'");

            } else if (position == SHOW_ALL_BOOKS_POSITION) {

                new BookPrinter().printBooks(BookRepository.getInstance().getBookRepository());
                break;

            } else if (position == SEARCH_BY_AUTHOR_POSITION) {
                new BookFinder().bookFinderSetup(1, chooseAudioOrNoAudio());
                break;
            } else if (position == SEARCH_BY_TITLE_POSITION) {
                new BookFinder().bookFinderSetup(2, chooseAudioOrNoAudio());
                break;
            } else if (position == SEARCH_BY_AUTHOR_OR_TITLE) {
                new BookFinder().bookFinderSetup(3, chooseAudioOrNoAudio());
                break;
            }

            menuBreadcrumbs(position);

            position = printMenu(position);
        }
    }

    private int chooseAudioOrNoAudio() {
        stdout.info("\nCzy czy ma być \n1) z Audio\n2) bez Audio \n3) obojętne czy ma audio");
        return getNumber.getChoice(3);
    }

    private int printMenu(int position) {
        stdout.info("Masz do wyboru:");
        int[] choicesNumber = printMenuOptions(position);
        printReturnMenuOption();
        int userChoice = getNumber.getChoice(choicesNumber.length);
        stdout.info("\nwybraleś " + userChoice + " \n");
        if (userChoice != 0) {
            position = choicesNumber[userChoice];
        } else {

            position = getParentFromList(position);
        }
        return position;
    }

    int[] printMenuOptions(int position) {
        int[] choicesNumber = new int[MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE];
        int pressNumber = 1;
        for (MenuOption menuOption : newMenuList) {
            if (menuOption.getParent() == position) {
                stdout.info("\n" + pressNumber + "<-  " + menuOption.getDisplayedText());
                choicesNumber[pressNumber] = menuOption.getPosition();
                pressNumber++;
            }
        }
        return choicesNumber;
    }

    private void printReturnMenuOption() {
        stdout.info("\n0<-  wróć do poprzedniego menu  ");
        stdout.info("\n wybierz numer opcji z menu: ");
    }

    void menuBreadcrumbs(int position) {
        int currentIndex = 0;
        String crumbs = "Glowne Menu";
        int crumbPosition = position;
        while (crumbPosition != MAIN_MENU_POSITION) {
            currentIndex = getIndexFromList(crumbPosition);
            crumbs = crumbs + " / " + newMenuList.get(currentIndex).getDisplayedText();
            crumbPosition = newMenuList.get(currentIndex).getParent();
        }
        stdout.info("\n" + crumbs + "\n");
    }

    private int getIndexFromList(int position) {
        int currentMenuIndex = 0;
        for (int i = 0; i < newMenuList.size(); i++) {
            if (newMenuList.get(i).getPosition() == position) {
                currentMenuIndex = i;
                return currentMenuIndex;
            }
        }
        return currentMenuIndex;
    }

    int getParentFromList(int position) {
        int parent = 0;

        for (int i = 0; i < newMenuList.size(); i++) {
            if (position == newMenuList.get(i).getPosition()) {
                parent = newMenuList.get(i).getParent();
                return parent;
            }
        }
        return parent;
    }

}

