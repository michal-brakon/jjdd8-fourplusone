package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MissingFileMenu {


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        stdout.info("\nWybierz: ");
        stdout.info("\n1 -       Wczytaj plik json jeszcze raz \n");
        stdout.info("\n2 -       Wyjście z aplikacji\n");
        Menu menu = new Menu();
        String choice = scanner.next();

        if (isNumber(choice)) {
            switch (choice) {

                case "1":
                    List<Book> parser = BookRepository.getInstance().getBooks();
                    Optional.ofNullable(parser).ifPresentOrElse(a -> {
                        stdout.info("\nBaza danych z książkami została załadowana\n");
                        menu.populateMenu();
                        try {
                            menu.showMenu(Menu.MAIN_MENU_POSITION);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }, this::showMenu);
                    break;

                case "2":
                    stdout.info("\nDo zobaczenia\n");
                    break;

                default:
                    break;
            }
        } else {

            stdout.info("\nBłędny wybór\n");

        }
    }

    private boolean isNumber(String choice) {
        return Pattern.matches(("[1-9]"), choice);
    }
}


