package com.infoshareacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.infoshareacademy.Menu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Menu")
class MenuTest {
    Menu menu = new Menu();


    @DisplayName("test YEY")
    @BeforeEach
    void setup() {

        menu.populateMenu();
    }

    @DisplayName("get correct parent from node")
    @Test
    public void get_proper_parent() {

        int position = SEARCH_BY_AUTHOR_OR_TITLE;

        // assert
        assertEquals(4, menu.getParentFromList(position));
    }

    @DisplayName("Menu Options Test")
    @Test
    public void get_correct_menu_options() {

        List<MenuOption> testList = new ArrayList<>();
        testList.add(new MenuOption("Pokaż Wszystkie pozycje", SHOW_ALL_BOOKS_POSITION, BOOK_MENU_POSITION));
        testList.add(new MenuOption("Wyświetl jedną pozycję", SHOW_ONE_BOOK_POSITION, BOOK_MENU_POSITION));
        // assert

        assertEquals(testList.toString(), menu.getMenuOptions(2).toString());

    }


}