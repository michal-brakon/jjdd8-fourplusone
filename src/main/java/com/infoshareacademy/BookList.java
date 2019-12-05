package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Scanner;

public class BookList {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    Menu menu = new Menu();

    public void printBooks(List<Book> books) {

        int record = 1;
        int counter = 0;
        int recordsLimit = 0;

        while (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) {

            stdout.info("\nHow many records on page? (5,10,15) ");
            recordsLimit = menu.getChoice(15);
            if (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) System.out.println("Wrong number!");
        }

        for (Book book : books) {

            if (record < books.size() + 1) stdout.info(record + ". " + book);
            counter++;
            record++;

            if (counter >= recordsLimit) {
                stdout.info("\nWpisz 'q' jesli chcesz opuscic liste, dowolny klawisz kontynuuje wyswietlanie\n");
                Scanner scanner = new Scanner(System.in);
                String choice = "";
                choice = scanner.next();
                if (choice.equals("q")) {
                    break;
                }
                counter = 0;
                ClearScreen.clearScreen();
            }
        }
        menuBookList();
    }

    private void menuBookList() {

        //counter = 1;
        stdout.info("\nWybierz: ");
        stdout.info("\nc -       choose book");
        stdout.info("\nm -       main menu");
        stdout.info("\nq -       close application");

        Scanner scanner = new Scanner(System.in);
        String choice1 = scanner.next();

        switch (choice1) {
            case "q": {
                exit();
                break;
            }
            case "m": {
                menu.mainMenu();
                break;
            }
            case "c": {
                int temp = chooseBookToPrint();
                stdout.info(temp + 1 +". "+ String.valueOf(BookRepository.getBooks().get(temp)));
                break;
            }
        }

        return;
    }

    private int chooseBookToPrint() {
        stdout.info("\nWpisz numer ksiazki: \n");
        Scanner scanner = new Scanner(System.in);
        int bookChoice = 0;
        try {
            bookChoice = scanner.nextInt() - 1;
        } catch (NumberFormatException e) {
            stdout.info("\nType a number of book!");
            chooseBookToPrint();
        }

        return bookChoice;

    }

    private void exit() {
        ClearScreen.clearScreen();
        stdout.info("\nDo zobaczenia!");
        System.exit(0);
        return;
    }
}


