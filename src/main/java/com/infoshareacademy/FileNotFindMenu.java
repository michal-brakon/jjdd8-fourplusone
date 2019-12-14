package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileNotFindMenu {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void showLoaderFileMenu() {

        Scanner scanner = new Scanner(System.in);
        stdout.info("\nWybierz: ");
        stdout.info("\n1 -       Wczytaj plik json jeszcze raz \n");
        stdout.info("\n2 -       Wyjście z aplikacji\n");
        Menu menu = new Menu();
        String choice = scanner.next();

        if (Pattern.matches(("[1-9]"), choice)) {
            switch (choice) {

                case "1": {
                    List<Book> parser = BookRepository.getInstance().getBooks();
                    Optional.ofNullable(parser).ifPresentOrElse(a -> {
                        System.out.println("\nBaza.json załadowana\n");
                        menu.mainMenu();
                    }, this::showLoaderFileMenu);
                    break;
                }
                case "2": {
                    stdout.info("\nDo zobaczenia\n");
                    break;
                }
                default:
                    stdout.info("Gorilla like bananas ug ug ug ug ug :-} ");
                    break;
            }
        } else {

            stdout.info("\nBłędny wybór\n");

        }
    }
}


