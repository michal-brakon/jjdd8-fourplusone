package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Menu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private int choice = 0;
    private Scanner scan = new Scanner(System.in);

    //BookList bookList = new BookList();



    public int getChoice(int choices) {

        stdout.info("\nGdzie chcesz się udać: \n");
        String userLineIn = scan.nextLine();

        try {
            choice = Integer.parseInt(userLineIn);
        } catch (NumberFormatException e) {
            stdout.info("\nWpisałeś litere! ");
            getChoice(choices);
        }
        if (choice > choices || choice < 0) {
            stdout.info("\nProsze wybrać jeden z " + choices + " wyborów");
            getChoice(choices);
        }

        return choice;
    }

    public void mainMenu() {

        stdout.info("\n1. wypozycz");
        stdout.info("\n2. oddaj");
        stdout.info("\n3. lista ksiazek");
        stdout.info("\n-----");
        stdout.info("\n0. wyjscie");

        switch (getChoice(3)) {

            case 1: {
                borrowBookMenu();
                break;
            }
            case 2: {
                returnBookMenu();
                break;
            }
            case 3: {
                bookListMenu();
                break;
            }

            case 0:
                exit();
        }

    }

    private void exit() {
        ClearScreen.clearScreen();
        stdout.info("\nDo zobaczenia!");
    }

    private void bookListMenu() {
        ClearScreen.clearScreen();
        stdout.info("\n1. Pokaż wszystkie pozycje");
        stdout.info("\n2. sortuj po gatunku");
        stdout.info("\n3. sortuj po tytule");
        stdout.info("\n4. główne menu");
        stdout.info("\n0. wyjscie");

        switch (getChoice(4)) {
            case 1: {
                new BookPrinter().printBooks(BookRepository.getBooks());
                //stdout.info(String.valueOf(BookRepository.getBooks()));
                mainMenu();
                break;
            }
            case 2: {
                stdout.info("\nMetod not yet implemented");
            }
            case 3: {
                stdout.info("\nMetod not yet implemented");
            }
            case 4: {
                mainMenu();
                break;
            }
            case 0:
                exit();
        }

    }

    private void returnBookMenu() {

    }

    private void borrowBookMenu() {

    }

}