package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BookPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    UserInput userInput = new UserInput();

    private int bookChoice = 0;

    private BookRepository bookRepository = BookRepository.getInstance();


    public void printBooks(List<Book> books) throws IOException {

        int record = 1;
        int counter = 0;
        int recordsLimit;

        ScreenCleaner.clearScreen();
        stdout.info("\nIle rekordów na stronie? (1-{} )\n", bookRepository.getBooks().size());
        recordsLimit = userInput.getChoice(bookRepository.getBooks().size());

        for (Book book : books) {

            if (record < books.size() + 1) {
                stdout.info("{} ", book);
            }
            counter++;
            record++;

            if (counter >= recordsLimit) {
                stdout.info("\nWpisz 'q' jeśli chcesz opuścić listę , dowolny znak kontynuuje wyświetlanie\n");
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

    public void printChosenBook() throws IOException {

        chooseBookToPrint();
        stdout.info("{}", bookRepository.getBooks().get(bookChoice));
        if (bookRepository.getBooks().get(bookChoice).favourite == "nie") {
            stdout.info("\nCzy dodac ksiazke do ulubionych? (t - tak) ");
            Scanner scanner = new Scanner(System.in);
            String confirmationChoice = scanner.next();
            if (confirmationChoice.equalsIgnoreCase("t")) {
                new FavouritesManager().addToFavourites(bookRepository.getBooks().get(bookChoice).getTitle());
            }
        } else {
            stdout.info("\nCzy usunac ksiazke z ulubionych? (t - tak) ");
            Scanner scanner = new Scanner(System.in);
            String confirmationChoice = scanner.next();
            if (confirmationChoice.equalsIgnoreCase("t")) {
                new FavouritesManager().removeFromFavourites(bookRepository.getBooks().get(bookChoice).getTitle());
            }
        }
        pressEnterKeyToContinue();
        menu.showMenu(Menu.BOOK_MENU_POSITION);

    }

    private void pressEnterKeyToContinue() {
        stdout.info("Przyciśnij Enter aby kontynuować");
        scanner.nextLine();
    }

    private boolean isCorrectChooseBook(String choice) {
        return (userInput.isANumber(choice)) && areThereThatManyBooks(choice);

    }

    private boolean areThereThatManyBooks(String choice) {
        return (Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= bookRepository.getBooks().size());
    }

    public int chooseBookToPrint() {
        stdout.info("\nWpisz numer książki: \n");
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


