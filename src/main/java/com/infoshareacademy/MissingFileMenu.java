package com.infoshareacademy;

import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MissingFileMenu {


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        stdout.info("\n", Language.getMessageByKey(LangKeyConfig.SELECT));
        stdout.info("\n{}\n", Language.getMessageByKey(LangKeyConfig.LOAD_JSON_FROM_FILE_AGAIN));
        stdout.info("\n{}\n", Language.getMessageByKey(LangKeyConfig.EXIT_FROM_APPLICATION));
        Menu menu = new Menu();
        String choice = scanner.next();

        if (isNumber(choice)) {
            switch (choice) {

                case "1":
                    List<Book> parser = BookRepository.getInstance().getBooks();
                    Optional.ofNullable(parser).ifPresentOrElse(a -> {
                        stdout.info("\n{}\n", Language.getMessageByKey(LangKeyConfig.DATABASE_LOADED));
                        menu.populateMenu();
                        menu.showMenu(Menu.MAIN_MENU_POSITION);
                    }, this::showMenu);
                    break;

                case "2":
                    stdout.info("\n{}\n", Language.getMessageByKey(LangKeyConfig.RETURN_TO_PREVIOUS_MENU));
                    break;

                default:
                    break;
            }
        } else {

            stdout.info("\n{}\n", Language.getMessageByKey(LangKeyConfig.INCORRECT_SELECTION));

        }
    }

    private boolean isNumber(String choice) {
        return Pattern.matches(("[1-9]"), choice);
    }
}


