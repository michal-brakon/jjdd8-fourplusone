package com.infoshareacademy;

import com.infoshareacademy.bookeditormenu.EditorMenu;
import com.infoshareacademy.bookmanagement.BookAdder;
import com.infoshareacademy.bookmanagement.DeleteBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshareacademy.App.newMenuList;

public class Menu {

    protected static final int SEARCH_BY_AUTHOR_POSITION = 6;
    protected static final int SEARCH_BY_TITLE_POSITION = 7;
    protected static final int ADD_BOOK_POSITION = 8;
    protected static final int MAIN_MENU_POSITION = 1;
    protected static final int BOOK_MENU_POSITION = 2;
    protected static final int EXIT_POSITION = 0;
    protected static final int SHOW_ALL_BOOKS_POSITION = 3;
    protected static final int SHOW_ONE_BOOK_POSITION = 4;
    protected static final int MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE = 7;
    protected static final int STARTING_MENU_OPTION_NUMBER = 1;
    protected static final int GO_BACK_OPTION_NUMBER = 0;
    protected static final int SAVE_TO_FILE = 10;
    protected static final int DELETE_BOOK = 9;
    protected static final int EDIT_BOOK = 13;


    public void populateMenu() {

        newMenuList.add(new MenuOption("Głowne menu", MAIN_MENU_POSITION, EXIT_POSITION));
        newMenuList.add(new MenuOption("Dostępne książki", BOOK_MENU_POSITION, MAIN_MENU_POSITION));
        newMenuList.add(new MenuOption("Pokaż Wszystkie pozycje", SHOW_ALL_BOOKS_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyświetl jedną pozycję", SHOW_ONE_BOOK_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po autorze", SEARCH_BY_AUTHOR_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po tytule", SEARCH_BY_TITLE_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Dodaj książke", ADD_BOOK_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("zapis do pliku", SAVE_TO_FILE, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("USUN REKORD ", DELETE_BOOK, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("EDYTUJ KSIĄŻKE ", EDIT_BOOK, SHOW_ONE_BOOK_POSITION));


    }

    private final BookRepository repository = BookRepository.getInstance();

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
                new BookPrinter().printBooks(repository.getBooks());
                break;
            } else if (position == DELETE_BOOK) {
                new DeleteBook().deleteBook();
                stdout.info("pozycja została usunięta \n");
                position = getParentFromList(position);
                new BookParser().saveObjectsToFile();
            } else if (position == SAVE_TO_FILE) {
                new BookParser().saveObjectsToFile();
                stdout.info("Baza Została zapisana");
                position = getParentFromList(position);

            } else if (position == ADD_BOOK_POSITION) {
                new BookAdder().addBook();
                new BookParser().saveObjectsToFile();
                position = getParentFromList(position);
            } else if (position == EDIT_BOOK) {
                new EditorMenu().bookEditorMenu();
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
        stdout.info("\nwybraleś {} \n", userChoice);
        if (userChoice != GO_BACK_OPTION_NUMBER) {
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
                stdout.info("\n {} <- {}", pressNumber, menuOption.getDisplayedText());
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
        stdout.info("\n 0 <-  wróć do poprzedniego menu  ");
        stdout.info("\n wybierz numer opcji z menu: ");
    }

    void showBreadCrumbsPosition(int position) {

        StringBuilder crumbs = new StringBuilder("Główne Menu");
        int crumbPosition = position;
        while (crumbPosition != MAIN_MENU_POSITION) {
            int currentIndex = getIndexFromList(crumbPosition);
            crumbs.append(" / ").append(newMenuList.get(currentIndex).getDisplayedText());
            crumbPosition = newMenuList.get(currentIndex).getParent();
        }
        stdout.info("\n{}\n", crumbs);
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

        for (MenuOption menuOption : newMenuList) {
            if (position == menuOption.getPosition()) {
                parent = menuOption.getParent();
                return parent;
            }
        }
        return parent;
    }

}

