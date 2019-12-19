package com.infoshareacademy;

import com.infoshareacademy.Language.Language;
import com.infoshareacademy.Language.LanguagesToChoose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
    protected static final int MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE = 10;
    protected static final int STARTING_MENU_OPTION_NUMBER = 1;
    protected static final int GO_BACK_OPTION_NUMBER = 0;
    protected static final int SORT_ALL_BOOKS_BY_AUTHOR = 21;
    protected static final int SORT_ALL_BOOKS_BY_TITLE = 22;
    protected static final int SORT_ALL_BOOKS_BY_GENRE = 23;
    protected static final int SORT_ALL_BOOKS_BY_KIND = 24;
    protected static final int SORT_ALL_BOOKS_BY_EPOCH = 25;
    protected static final int CHANGE_LANGUAGE_OPTION = 99;

    Language l = new Language(LanguagesToChoose.ENG.getValue());


    public void populateMenu() {

        newMenuList.add(new MenuOption("Głowne menu", MAIN_MENU_POSITION, EXIT_POSITION));
        newMenuList.add(new MenuOption("Dostępne książki", BOOK_MENU_POSITION, MAIN_MENU_POSITION));
        newMenuList.add(new MenuOption("Pokaż Wszystkie pozycje", SHOW_ALL_BOOKS_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyświetl jedną pozycję", SHOW_ONE_BOOK_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po autorze", SEARCH_BY_AUTHOR_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po tytule", SEARCH_BY_TITLE_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po autorze  tytule", SEARCH_BY_AUTHOR_OR_TITLE, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po autorze", SORT_ALL_BOOKS_BY_AUTHOR, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po tytule", SORT_ALL_BOOKS_BY_TITLE, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po gatunku ", SORT_ALL_BOOKS_BY_GENRE, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po epoce", SORT_ALL_BOOKS_BY_EPOCH, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po rodzaju", SORT_ALL_BOOKS_BY_KIND, SHOW_ALL_BOOKS_POSITION));

    }

    private final BookRepository repository = BookRepository.getInstance();

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();

    public void showMenu(int position) {

        while (position != EXIT_POSITION) {
            ScreenCleaner.clearScreen();
            if (position <= 10) {
                Header.headerPrinter();
            }
            // adding functionality on positions here from this point
            if (position == SORT_ALL_BOOKS_BY_TITLE) {
                BookSorter bookSorter = new BookSorter();
                List<Book> listOfBooks = bookSorter.sortingByTitle(repository.getBooks());
                new BookPrinter().printBooks(listOfBooks);
                position = getParentFromList(position);
            } else if (position == SORT_ALL_BOOKS_BY_AUTHOR) {
                BookSorter bookSorter = new BookSorter();
                List<Book> listOfBooks = bookSorter.sortingByAuthor(repository.getBooks());
                new BookPrinter().printBooks(listOfBooks);
                position = getParentFromList(position);
            } else if (position == SORT_ALL_BOOKS_BY_GENRE) {
                BookSorter bookSorter = new BookSorter();
                List<Book> listOfBooks = bookSorter.sortingByGenre(repository.getBooks());
                new BookPrinter().printBooks(listOfBooks);
                position = getParentFromList(position);
            } else if (position == SORT_ALL_BOOKS_BY_EPOCH) {
                BookSorter bookSorter = new BookSorter();
                List<Book> listOfBooks = bookSorter.sortingByEpoch(repository.getBooks());
                new BookPrinter().printBooks(listOfBooks);
                position = getParentFromList(position);
            } else if (position == SORT_ALL_BOOKS_BY_KIND) {
                BookSorter bookSorter = new BookSorter();
                List<Book> listOfBooks = bookSorter.sortingByKind(repository.getBooks());
                new BookPrinter().printBooks(listOfBooks);
                position = getParentFromList(position);
            } else if (position == SHOW_ONE_BOOK_POSITION) {
                new BookPrinter().printChosenBook();
                position = getParentFromList(position);
            }

            showBreadCrumbsPosition(position);

            position = printMenu(position);
        }
    }

    private int printMenu(int position) {
        stdout.info("Masz do wyboru:");
        int[] choicesNumber = printMenuOptions(position);
        printReturnMenuOption();

        int userChoice = getNumber.getChoice(getMenuSize(position) - 1);
        if (userChoice == CHANGE_LANGUAGE_OPTION) {

            return position;
        } else if (userChoice != GO_BACK_OPTION_NUMBER) {
            position = choicesNumber[userChoice];
        } else {

            position = getParentFromList(position);
        }
        return position;
    }

    int[] printMenuOptions(int position) {
        int[] choicesNumber = new int[MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE];
        int pressNumber = STARTING_MENU_OPTION_NUMBER;
        for (MenuOption menuOption : newMenuList) {
            if (menuOption.getParent() == position) {
                stdout.info("\n {} <- {} ", pressNumber, menuOption.getDisplayedText());
                choicesNumber[pressNumber] = menuOption.getPosition();
                pressNumber++;
            }
        }
        return choicesNumber;
    }

    private int getMenuSize(int position) {
        int pressNumber = STARTING_MENU_OPTION_NUMBER;
        for (MenuOption menuOption : newMenuList) {
            if (menuOption.getParent() == position) {
                pressNumber++;
            }
        }
        return pressNumber;
    }

    private void printReturnMenuOption() {
        stdout.info("\n 0 <- wróć do poprzedniego menu  ");
        stdout.info("\n wybierz numer opcji z menu: ");
    }

    private void showBreadCrumbsPosition(int position) {

        StringBuilder crumbs = new StringBuilder("");
        int crumbPosition = position;
        while (crumbPosition != EXIT_POSITION) {
            int currentIndex = getIndexFromList(crumbPosition);
            crumbs.insert(0, " / ").insert(0, newMenuList.get(currentIndex).getDisplayedText());
            crumbPosition = newMenuList.get(currentIndex).getParent();
        }
        stdout.info("\n/ {}\n", crumbs);
    }

    private int getIndexFromList(int position) {
        int currentMenuIndex = EXIT_POSITION;
        for (int i = 0; i < newMenuList.size(); i++) {
            if (newMenuList.get(i).getPosition() == position) {
                currentMenuIndex = i;
                return currentMenuIndex;
            }
        }
        return currentMenuIndex;
    }

    int getParentFromList(int position) {
        int parent = EXIT_POSITION;

        for (int i = 0; i < newMenuList.size(); i++) {
            if (position == newMenuList.get(i).getPosition()) {
                parent = newMenuList.get(i).getParent();
                return parent;
            }
        }
        return parent;
    }

}

