package com.infoshareacademy;

import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.LanguageChooser;
import com.infoshareacademy.Language.LanguageMessagesHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class App {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    static List<MenuOption> newMenuList = new ArrayList<>();
    private static Menu menu = new Menu();


    public static void main(String[] args) {
        LanguageChooser nowy = new LanguageChooser();



        MissingFileMenu missingFileMenu = new MissingFileMenu();
        Optional.ofNullable(BookRepository.getInstance().getBooks())
                .ifPresentOrElse(books -> {
                    stdout.info(nowy.getMessageByKey(LangKeyConfig.DATABASE_LOADED));
                    menu.populateMenu();
                    menu.showMenu(Menu.MAIN_MENU_POSITION);
                }, missingFileMenu::showMenu);
    }


    }
}