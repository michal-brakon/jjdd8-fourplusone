package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Menu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private int choice = 0;
    private Scanner scan = new Scanner(System.in);

    public int getChoice(int choices) {


        String userLineIn = scan.nextLine();
        if (Pattern.matches(("[0-"+choices+"]"), userLineIn)) {

                choice = Integer.parseInt(userLineIn);

        } else {
            stdout.info("Źle wpisałeś! \nSprobuj ponownie:\n");
            getChoice(choices);
        }
//        if (choice > choices || choice < 0) {
//            stdout.info("\nProsze wybrać jeden z " + choices);
//            getChoice(choices);
//        }

        return choice;
    }

    public void mainMenu() {
        ClearScreen.clearScreen();

        stdout.info("\n1. Przeglądaj zbiór książek");
        stdout.info("\n2. Rezerwacja pozycji");
        stdout.info("\n3. Ulubione");
        stdout.info("\n4  Zarzadzanie zbiorem");

        stdout.info("\n0. wyjscie\n");

        switch (getChoice(4)) {

            case 1: {
                bookListMenu();
                break;
            }
            case 2: {
                borrowBookMenu();
                break;
            }
            case 3: {
                favoritesMenu();
                break;
            }
            case 4: {
                managerBookMenu();
                break;
            }

            case 0:
                exit();
                break;
        }

    }

    private void exit() {
        ClearScreen.clearScreen();
        stdout.info("\nDo zobaczenia!");
        return;
    }

    void bookListMenu() {
        ClearScreen.clearScreen();

        stdout.info("\n1. Pokaż wszystkie pozycje");
        stdout.info("\n2. Wyswietl jedna pozycje");
        stdout.info("\n3. Szukaj");
        stdout.info("\n4. główne menu");
        stdout.info("\n0. wyjscie\n");

        switch (getChoice(4)) {
            case 1: {
                new BookPrinter().printBooks(BookRepository.getBooks());
                mainMenu();
                break;
            }
            case 2: {
                int n = new BookPrinter().chooseBookToPrint();
                stdout.info(n + 1 + ". " + BookRepository.getBooks().get(n));
                stdout.info("\n Nacisnij dowolny klawisz aby kontynuawać\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice != null)
                    bookListMenu();
                break;

            }
            case 3: {
                new SearchBook().searchFromAuthor();

                break;

            }
            case 4: {
                mainMenu();
                break;
            }
            case 0:
                exit();
                break;
        }

    }

    private void favoritesMenu() {
        stdout.info("Feature in progress\n");
        mainMenu();
        return;

    }

    private void borrowBookMenu() {
        ClearScreen.clearScreen();

        stdout.info("\n1. Dodaj ksiażke do rezerwacji");
        stdout.info("\n2. Usuń ksiażkę z rezerwacji");
        stdout.info("\n3. Powrot do menu glownego");
        stdout.info("\n4. Zamknij aplikacje\n");


        switch (getChoice(4)) {
            case 1: {
                stdout.info("Feature in progress!\n");
                borrowBookMenu();
                break;
            }
            case 2: {
                stdout.info("Feature in progress!\n");
                borrowBookMenu();
                break;
            }
            case 3: {
                mainMenu();
                break;
            }
            case 4: {
                exit();
                break;

            }


        }
    }

    private void managerBookMenu() {
        stdout.info("Feature in progress\n");
        mainMenu();
        exit();
    }

}