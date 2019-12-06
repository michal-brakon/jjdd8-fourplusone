package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Scanner;

public class BookPrinter {
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
                stdout.info("\nWpisz 'q' jesli chcesz opuscic liste i zamknac aplikacje, dowolny klawisz kontynuuje wyswietlanie\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (checkChoice(choice)) {
                    if (choice.equals("q")) {
                        exit();
                        break;
                    }
                    counter = 0;
                    ClearScreen.clearScreen();
                }
            }
        }
        menuBookList();
    }

    private void menuBookList() {

        stdout.info("\nWybierz: ");
        stdout.info("\nc -       choose book");
        stdout.info("\nm -       main menu");
        stdout.info("\nq -       close application\n");

        Scanner scanner = new Scanner(System.in);
        String choice1 = scanner.next();

        if (checkChoice1(choice1)) {
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
                    stdout.info(temp + 1 + ". " + String.valueOf(BookRepository.getBooks().get(temp)));
                    menuBookList();
                    break;
                }
            }
        } else {
            stdout.info("\nBledny wybor");
            menuBookList();
        }

        return;
    }
    private boolean checkChoice (String choice) {
        return (choice != null);
    }

    private boolean checkChoice1 (String choice) {
        return (choice != null && (choice.equals("q") || choice.equals("m") || choice.equals("c")));

    }
    private boolean checkChooseBook (String choice) {
        return (choice != null && Integer.valueOf(choice) > 1 && Integer.valueOf(choice) <= BookRepository.getBooks().size());

    }

    private int chooseBookToPrint() {
        stdout.info("\nWpisz numer ksiazki: \n");
        Scanner scanner = new Scanner(System.in);
        String bookChoiceStr = scanner.next();
        int bookChoice = 0;
        if (checkChooseBook(bookChoiceStr)) {
            bookChoice = Integer.valueOf(bookChoiceStr) -1;
        }   else {
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


