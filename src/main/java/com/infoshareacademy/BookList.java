package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    ArrayList<Book> myList = new ArrayList<>();
    private int record;
    private int recordsLimit = 0;
    private int counter;
    Menu menu = new Menu();

    public static void main(String[] args) {
        str.split("=");
    }

    public void printBooks(ArrayList<Book> books) {

        record = 1;
        counter = 1;
        recordsLimit = 0;

        while (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) {
            stdout.info("\nHow many records on page? (5,10,15) ");
            recordsLimit = menu.getChoice(15);
            if (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) System.out.println("Wrong number!");
        }

        for (Book book : books) {

            if (record < books.size() + 1) stdout.info(record + ". " + book);
            counter++;
            record++;

            if (counter > recordsLimit) {
                stdout.info("\nType q to finish list, any to continue book list");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("q")) {
                    record = books.size() + 1;
                }
                counter = 1;
                ClearScreen.clearScreen();
            }
        }
        menuBookList();
    }

    private void menuBookList() {

        counter = 1;
        stdout.info("\nType your choice: ");
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

                break;
            }
            case "c": {
                stdout.info(String.valueOf(myList.get(chooseBookToPrint())));
                break;
            }
        }

        return;
    }

    private int chooseBookToPrint() {
        stdout.info("\nWpisz numer ksiazki: ");
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
    }

}


