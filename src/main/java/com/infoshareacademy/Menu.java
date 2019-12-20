package com.infoshareacademy;

import com.infoshareacademy.bookeditormenu.EditorMenu;
import com.infoshareacademy.bookmanagement.BookAdder;
import com.infoshareacademy.bookmanagement.DeleteBook;
import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.infoshareacademy.App.newMenuList;

public class Menu {
    protected static final int ADD_BOOK_POSITION = 10;
    protected static final int SEARCH_BY_AUTHOR_POSITION = 6;
    protected static final int SEARCH_BY_TITLE_POSITION = 7;
    protected static final int SEARCH_BY_AUTHOR_OR_TITLE = 8;
    protected static final int MAIN_MENU_POSITION = 1;
    protected static final int BOOK_MENU_POSITION = 2;
    protected static final int EXIT_POSITION = 0;
    protected static final int SHOW_ALL_BOOKS_POSITION = 3;
    protected static final int SHOW_ONE_BOOK_POSITION = 4;
    protected static final int GO_BACK_OPTION_NUMBER = 0;
    protected static final int SORT_ALL_BOOKS_BY_AUTHOR = 21;
    protected static final int SORT_ALL_BOOKS_BY_TITLE = 22;
    protected static final int SORT_ALL_BOOKS_BY_GENRE = 23;
    protected static final int SORT_ALL_BOOKS_BY_KIND = 24;
    protected static final int SORT_ALL_BOOKS_BY_EPOCH = 25;
    protected static final int CHANGE_LANGUAGE_OPTION = 99;
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    protected static final int SAVE_TO_FILE = 11;
    protected static final int DELETE_BOOK = 9;
    protected static final int EDIT_BOOK = 13;


   private static boolean language = true;
    private final BookRepository repository = BookRepository.getInstance();
    UserInput getNumber = new UserInput();
    Language l = new Language();
    Locale locale = new Locale("eng");

    public void setLanguage(boolean language) {
        if (language) {

            l.setMessagesBundle(ResourceBundle.getBundle("messages", locale));

            language = false;

        } else {
            l.setMessagesBundle(ResourceBundle.getBundle("messages_pl", locale));
            language = true;
        }
    }

    public void populateMenu() {

        newMenuList.add(new MenuOption("Dodaj książke", ADD_BOOK_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("zapis do pliku", SAVE_TO_FILE, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("USUN REKORD ", DELETE_BOOK, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("EDYTUJ KSIĄŻKE ", EDIT_BOOK, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.MAIN_MENU_POSITION), MAIN_MENU_POSITION, EXIT_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.AVAILABLE_BOOKS), BOOK_MENU_POSITION, MAIN_MENU_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.SHOW_ALL_ITEMS), SHOW_ALL_BOOKS_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.DISPLAY_ONE_ITEM), SHOW_ONE_BOOK_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.SEARCH_BY_AUTHOR), SEARCH_BY_AUTHOR_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.SEARCH_BY_TITLE), SEARCH_BY_TITLE_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po autorze  tytule", SEARCH_BY_AUTHOR_OR_TITLE, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po autorze", SORT_ALL_BOOKS_BY_AUTHOR, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po tytule", SORT_ALL_BOOKS_BY_TITLE, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po gatunku ", SORT_ALL_BOOKS_BY_GENRE, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po epoce", SORT_ALL_BOOKS_BY_EPOCH, SHOW_ALL_BOOKS_POSITION));
        newMenuList.add(new MenuOption("Wyświetl wszystkie pozycje po rodzaju", SORT_ALL_BOOKS_BY_KIND, SHOW_ALL_BOOKS_POSITION));

    }

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
            } else if (position == SEARCH_BY_AUTHOR_POSITION) {
                new BookFinder().runBookFinder(1, choseAudioOrNoAudio());
                position = getParentFromList(position);
            } else if (position == SEARCH_BY_TITLE_POSITION) {
                new BookFinder().runBookFinder(2, choseAudioOrNoAudio());
                position = getParentFromList(position);
            } else if (position == SEARCH_BY_AUTHOR_OR_TITLE) {
                new BookFinder().runBookFinder(3, choseAudioOrNoAudio());

                position = getParentFromList(position);
            } else if (position == SHOW_ALL_BOOKS_POSITION) {
                new BookPrinter().printBooks(repository.getBooks());
                break;
            } else if (position == DELETE_BOOK) {
                new DeleteBook().deleteBook();
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

    private int choseAudioOrNoAudio() {
        stdout.info("\n czy pozycja: \n 1 <- ma mieć audiobooka \n 2 <- czy nie ma mieć audiobooka");
        return getNumber.getChoice(2);
    }

    private int printMenu(int position) {
        stdout.info(l.getMessageByKey(LangKeyConfig.YOU_CAN_CHOOSE));
        List<MenuOption> temporaryMenu = getMenuOptions(position);
        printMenuOptions(temporaryMenu);
        printReturnMenuOption();


        int userChoice = getNumber.getChoice(temporaryMenu.size());
        if (userChoice == CHANGE_LANGUAGE_OPTION) {
            setLanguage(language);
            return position;
        } else if (userChoice != GO_BACK_OPTION_NUMBER) {
            position = temporaryMenu.get(userChoice - 1).getPosition();

        } else {

            position = getParentFromList(position);
        }
        return position;
    }


    List<MenuOption> getMenuOptions(int position) {
        return newMenuList.stream()
                .filter(menu -> menu.getParent() == position)
                .collect(Collectors.toList());
    }

    private void printMenuOptions(List<MenuOption> list) {
        for (int i = 0; i < list.size(); i++) {
            stdout.info("\n {} <- {}", i + 1, list.get(i).getDisplayedText());

        }
    }


    private void printReturnMenuOption() {
        stdout.info("\n {}\n", l.getMessageByKey(LangKeyConfig.RETURN_TO_PREVIOUS_MENU));
        stdout.info(l.getMessageByKey(LangKeyConfig.SELECT_THE_OPTION_NUMBER_FROM_MENU));
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

