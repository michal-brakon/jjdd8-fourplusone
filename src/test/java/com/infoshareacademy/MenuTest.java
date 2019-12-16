package com.infoshareacademy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.infoshareacademy.Menu.SEARCH_BY_AUTHOR_OR_TITLE;
import static com.infoshareacademy.Menu.SHOW_ONE_BOOK_POSITION;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Menu")
class MenuTest {
    Menu menu = new Menu();

    @DisplayName("test YEY")
    @BeforeAll
    void setup() {

        menu.populateMenu();
    }

    @Test
    private void get_proper_parent() {

        int position = SEARCH_BY_AUTHOR_OR_TITLE;

        // assert
        assertEquals(2,menu.getParentFromList(position));
    }
    @DisplayName("where do the choices lead")
    @Test
    private void get_correct_menu_options(){
        int position = SHOW_ONE_BOOK_POSITION;
        // assert

        assertEquals(1,menu.printMenuOptions(position));

    }


}