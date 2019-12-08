package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BookPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    Menu menu = new Menu();

    public void printBooks(List<Book> books) throws IOException {

        int record = 1;
        int counter = 0;
        int recordsLimit = 0;

        while (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) {

            stdout.info("\nIle rekordow na stronie? (5,10,15) ");
            recordsLimit = menu.getChoice(15);
            if (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) System.out.println("Zly wybor!");
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

    private void menuBookList() throws IOException {

        stdout.info("\nWybierz: ");
        stdout.info("\nc -       wybierz nr ksiazki");
        stdout.info("\nm -       powrot do menu glownego");
        stdout.info("\nq -       zamknij aplikacje\n");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (checkChoiceEndMenu(choice)) {
            switch (choice) {
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
                    stdout.info(temp + 1 + ". " + BookRepository.getInstance().getBookRepository().get(temp));
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

    private boolean checkChoiceEndMenu (String choice) {
        return (choice != null && (choice.equals("q") || choice.equals("m") || choice.equals("c")));

    }
    private boolean checkChooseBook (String choice) {
        return (choice != null && Integer.parseInt(choice) > 1 && Integer.parseInt(choice) <= BookRepository.getInstance().getBookRepository().size());

    }
    

    private int chooseBookToPrint() {
        stdout.info("\nWpisz numer ksiazki: \n");
        Scanner scanner = new Scanner(System.in);
        String bookChoiceStr = scanner.next();
        int bookChoice = 0;
        if (checkChooseBook(bookChoiceStr)) {
            bookChoice = Integer.parseInt(bookChoiceStr) -1;
        }   else {
            stdout.info("\nWpisz numer ksiazki!");
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


