package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    Menu menu = new Menu();
    private int bookChoice = 0;
    private boolean isExit = false;


    public void printBooks(List<Book> books) {

        int record = 1;
        int counter = 0;
        int recordsLimit = 0;

            ScreenCleaner.clearScreen();
            stdout.info("\nIle rekordow na stronie? (1-"+ BookRepository.getInstance().getBookRepository().size() +")\n ");
            recordsLimit = UserInput.getChoice(BookRepository.getInstance().getBookRepository().size());

        for (Book book : books) {

            if (record < books.size() + 1) stdout.info(record + ". " + book);
            counter++;
            record++;

            if (counter >= recordsLimit) {
                stdout.info("\nWpisz 'q' jesli chcesz opuscic liste , dowolny znak kontynuuje wyswietlanie\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("q")) {
                        menuBookList();
                        break;
                    }
                    counter = 0;
                    ScreenCleaner.clearScreen();
            }
        }
        if (!isExit) {
            menuBookList();
        }
    }

    private void menuBookList() {

        stdout.info("\nWybierz: ");
        stdout.info("\nc -       widok pojedyńczej ksiazki");
        stdout.info("\nm -       powrot do menu glownego\n");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (isCorrectChoiceEndMenu(choice)) {
            switch (choice) {

                case "m": {

                    break;
                }
                case "c": {
                    int temp = chooseBookToPrint();
                    stdout.info(temp + 1 + ". " + BookRepository.getInstance().getBookRepository().get(temp));
                    chooseBookToPrint();
                    stdout.info(bookChoice + 1 + ". " + BookRepository.getInstance().getBookRepository().get(bookChoice));
                    menuBookList();
                    break;
                }
                default: break;
            }
        } else {
            stdout.info("\nBledny wybor\n");
            menuBookList();
        }

    }

    private boolean isCorrectChoiceEndMenu(String choice) {
        return (choice != null && (choice.equals("m") || choice.equals("c")));

    }

    private boolean isCorrectChooseBook(String choice) {
        return ((Pattern.matches(("[0-9][0-9]"), choice) || Pattern.matches(("[0-9]"), choice)) && (Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= BookRepository.getInstance().getBookRepository().size()));

    }


    public int chooseBookToPrint() {
        stdout.info("\nWpisz numer ksiazki: \n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

            if (!isCorrectChooseBook(choice)) {
                stdout.info("Błędny wybor! Spróbuj ponownie!: \n");
                bookChoice = 0;
                chooseBookToPrint();
            }  else {
                bookChoice = Integer.parseInt(choice) -1 ;
                return bookChoice;
            }

        return bookChoice;
    }

}


