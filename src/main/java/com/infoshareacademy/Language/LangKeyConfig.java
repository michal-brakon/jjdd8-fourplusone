package com.infoshareacademy.Language;

public enum LangKeyConfig {


    DATABASE_LOADED("the_book_database_has_been_loaded"),
    AVAILABLE_BOOKS("available_books"),
    MAIN_MENU_POSITION("main_menu"),
    SHOW_ALL_ITEMS("show_all_items"),
    DISPLAY_ONE_ITEM("display_one_item"),
    SEARCH_BY_AUTHOR("search_by_author"),
    SEARCH_BY_TITLE("search_by_title");



    private String value;

    LangKeyConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
