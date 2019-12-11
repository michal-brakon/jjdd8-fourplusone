package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionMenu {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void showExceptionMenu() {

        Scanner scanner = new Scanner(System.in);
        stdout.info("\nWybierz: ");
        stdout.info("\n1 -       Wczytaj plik json jeszcze raz \n");
        stdout.info("\n2 -       powróć do menu aplikacji\n");
        Menu menu = new Menu();
        String choice = scanner.next();

        if (Pattern.matches(("[1-9]"), choice)) {
            switch (choice) {

                case "1": {
                    BookRepository.getInstance().getBookRepository();
                    if (BookRepository.getInstance().getBookRepository()!=null)
                    {menu.mainMenu();}
                    break;
                }
                case "2": {
                   menu.mainMenu();
                    break;
                }
                default:

                    break;
            }
        } else {

            stdout.info("\nBledny wybor\n");

        }
    }
}


