package com.infoshareacademy.Language;

public enum LangKeyConfig {

    BOOK_MENU_POSITION("main_menu"),
    BACK_TO_MENU("back"),
    MAIN_MENU_POSITION
    EXIT_POSITION
    DATABASE_LOADED("book.set.loaded")
    BOOK_MENU_POSITION()
    SHOW_ALL_BOOKS_POSITION("show_all_items"),
    MAX_MENU_OPTIONS_NUMBER_FOR_ONE_NODE
    STARTING_MENU_OPTION_NUMBER
    GO_BACK_OPTION_NUMBER
    SHOW_ONE_BOOK_POSITION
    SEARCH_BY_AUTHOR_POSITION
    SEARCH_BY_TITLE_POSITION("search_by_title"),
    SEARCH_BY_AUTHOR_OR_TITLE

    private String value;

    LangKeyConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
