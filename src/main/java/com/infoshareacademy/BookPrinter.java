package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    Menu menu = new Menu();
    boolean isExit = false;


    public void printBooks(List<Book> books) {

        int record = 1;
        int counter = 0;
        int recordsLimit = 0;

            ClearScreen.clearScreen();
            stdout.info("\nIle rekordow na stronie? \n ");
            recordsLimit = menu.getChoice(BookRepository.getBooks().size());

        for (Book book : books) {

            if (record < books.size() + 1) stdout.info(record + ". " + book);
            counter++;
            record++;

            if (counter >= recordsLimit) {
                stdout.info("\nWpisz 'q' jesli chcesz opuscic liste , dowolny klawisz kontynuuje wyswietlanie\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (checkChoice(choice)) {
                    if (choice.equals("q")) {
                        menuBookList();
                        break;

                    }
                    counter = 0;
                    ClearScreen.clearScreen();
                }
            }
        }
        if (!isExit) menuBookList();
    }

    private void menuBookList() {

        stdout.info("\nWybierz: ");
        stdout.info("\nc -       widok pojedyńczej ksiazki");
        stdout.info("\nm -       powrot do menu glownego\n");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (checkChoiceEndMenu(choice)) {
            switch (choice) {

                case "m": {
                    isExit = true;
                    menu.mainMenu();
                    break;
                }
                case "c": {
                    int temp = chooseBookToPrint();
                    stdout.info(temp + 1 + ". " + BookRepository.getBooks().get(temp));
                    menuBookList();
                    break;
                }
            }
        } else {
            stdout.info("\nBledny wybor\n");
            menuBookList();
        }

    }

    private boolean checkChoice(String choice) {
        return (choice != null);
    }

    private boolean checkChoiceEndMenu(String choice) {
        return (choice != null && (choice.equals("m") || choice.equals("c")));

    }

    private boolean checkChooseBook(String choice) {
        return (choice != null && Integer.parseInt(choice) > 1 && Integer.parseInt(choice) <= BookRepository.getBooks().size());

    }


    public int chooseBookToPrint() {
        stdout.info("\nWpisz numer ksiazki: \n");
        Scanner scanner = new Scanner(System.in);
        String bookChoiceStr = scanner.next();
        int bookChoice = 0;

        if (Pattern.matches(("[0-9][0-9]"), bookChoiceStr) || Pattern.matches(("[0-9]"), bookChoiceStr)) {

            if (checkChooseBook(bookChoiceStr)) {
                bookChoice = Integer.parseInt(bookChoiceStr) - 1;
            }
            return bookChoice;

        }
        stdout.info("błędny znak! ");

        return chooseBookToPrint();
    }

}


