package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class BookPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    Menu menu = new Menu();
    UserInput userInput = new UserInput();

    private int bookChoice = 0;

    private BookRepository bookRepository = BookRepository.getInstance();

    public void printBooks(List<Book> books) {

        int record = 1;
        int counter = 0;
        int recordsLimit = 0;

        ScreenCleaner.clearScreen();
        stdout.info("\nIle rekordów na stronie? (1-" + bookRepository.getBooks().size() + ")\n ");
        recordsLimit = userInput.getChoice(bookRepository.getBooks().size());

        for (Book book : books) {

            if (record < books.size() + 1) stdout.info(record + ". " + book);
            counter++;
            record++;

            if (counter >= recordsLimit) {
                stdout.info("\nWpisz 'q' jeśli chcesz opuścić listę , dowolny znak kontynuuje wyświetlanie\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("q")) {

                    break;
                }
                counter = 0;
                ScreenCleaner.clearScreen();
            }
        }
        menu.showMenu(Menu.BOOK_MENU_POSITION);
    }

    public void printChosenBook() {

        chooseBookToPrint();
        stdout.info(bookChoice + 1 + ". " + bookRepository.getBooks().get(bookChoice));
        pressEnterKeyToContinue();
        menu.showMenu(Menu.BOOK_MENU_POSITION);

    }

    private void pressEnterKeyToContinue() {
        stdout.info("Przyciśnij Enter aby kontynuować");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    private boolean isCorrectChooseBook(String choice) {
        return (userInput.isANumber(choice)) && areThereThatManyBooks(choice);

    }

    private boolean areThereThatManyBooks(String choice) {
        return (Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= bookRepository.getBooks().size());
    }

    public int chooseBookToPrint() {
        stdout.info("\nWpisz numer książki: \n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (!isCorrectChooseBook(choice)) {
            stdout.info("Błędny wybór! Spróbuj ponownie!: \n");
            bookChoice = 0;
            chooseBookToPrint();
        } else {
            bookChoice = Integer.parseInt(choice) - 1;
            return bookChoice;
        }
        return bookChoice;
    }

}


