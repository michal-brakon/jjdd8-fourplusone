package com.infoshareacademy;

import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import com.infoshareacademy.Language.LanguagesToChoose;
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
    protected static final int STARTING_MENU_OPTION_NUMBER = 1;
    protected static final int GO_BACK_OPTION_NUMBER = 0;

    Language l = new Language();

    public void populateMenu() {

        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.MAIN_MENU_POSITION), MAIN_MENU_POSITION, EXIT_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.AVAILABLE_BOOKS), BOOK_MENU_POSITION, MAIN_MENU_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.SHOW_ALL_ITEMS), SHOW_ALL_BOOKS_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.DISPLAY_ONE_ITEM), SHOW_ONE_BOOK_POSITION, BOOK_MENU_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.SEARCH_BY_AUTHOR), SEARCH_BY_AUTHOR_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption(l.getMessageByKey(LangKeyConfig.SEARCH_BY_TITLE), SEARCH_BY_TITLE_POSITION, SHOW_ONE_BOOK_POSITION));
        newMenuList.add(new MenuOption("Wyszukaj po autorze  tytule", SEARCH_BY_AUTHOR_OR_TITLE, SHOW_ONE_BOOK_POSITION));

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

                stdout.info(l.getMessageByKey(LangKeyConfig.WELCOME));


            } else if (position == SHOW_ALL_BOOKS_POSITION) {
                new BookPrinter().printBooks(repository.getBooks());
                break;
            } else if (position == SHOW_ONE_BOOK_POSITION) {
                new BookPrinter().printChosenBook();
                break;
            }

            showBreadCrumbsPosition(position);

            position = printMenu(position);
        }
    }



    private int printMenu(int position) {
        stdout.info(l.getMessageByKey(LangKeyConfig.YOU_CAN_CHOOSE));
        int[] choicesNumber = printMenuOptions(position);
        printReturnMenuOption();
        int userChoice = getNumber.getChoice(choicesNumber.length);
        stdout.info("\nwybraleś {} \n",  userChoice);
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

    private void printReturnMenuOption() {
        stdout.info("\n{}\n",l.getMessageByKey(LangKeyConfig.RETURN_TO_PREVIOUS_MENU));
        stdout.info(l.getMessageByKey(LangKeyConfig.SELECT_THE_OPTION_NUMBER_FROM_MENU));
    }

    void showBreadCrumbsPosition(int position) {

        StringBuilder crumbs = new StringBuilder(l.getMessageByKey(LangKeyConfig.MAIN_MENU_POSITION));
        int crumbPosition = position;
        while (crumbPosition != MAIN_MENU_POSITION) {
            int currentIndex = getIndexFromList(crumbPosition);
            crumbs.append(" / ").append(newMenuList.get(currentIndex).getDisplayedText());
            crumbPosition = newMenuList.get(currentIndex).getParent();
        }
        stdout.info("\n{}", crumbs);
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