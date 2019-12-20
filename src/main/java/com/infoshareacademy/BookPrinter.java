package com.infoshareacademy;

import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.Language.LangKeyConfig.*;
public class BookPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    Language l = new Language();
    private static final Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    UserInput userInput = new UserInput();

    private int bookChoice = 0;

    private BookRepository bookRepository = BookRepository.getInstance();


    public void printBooks(List<Book> books) {

        int record = 1;
        int counter = 0;
        int recordsLimit = 0;

        ScreenCleaner.clearScreen();
        stdout.info("\nIle rekordów na stronie? (1-{} )\n", bookRepository.getBooks().size());
        recordsLimit = userInput.getChoice(bookRepository.getBooks().size());

        for (Book book : books) {

            if (record < books.size() + 1) {
                stdout.info("{}. {} ", record, book);
            }
            counter++;
            record++;

            if (counter >= recordsLimit) {
                stdout.info("\n{}\n", l.getMessageByKey(RETURN_TO_PREVIOUS_MENU));
                String choice = scanner.next();
                if (choice.equals("q")) {

                    break;
                }
                counter = 0;
                ScreenCleaner.clearScreen();
            }
        }
    }

    public void printChosenBook() {

        chooseBookToPrint();
        stdout.info("{} . {}", bookChoice + 1, bookRepository.getBooks().get(bookChoice));
        pressEnterKeyToContinue();
        menu.showMenu(Menu.BOOK_MENU_POSITION);

    }

    private void pressEnterKeyToContinue() {
        stdout.info(l.getMessageByKey(PRESS_ENTER_TO_CONTINUE));
        scanner.nextLine();
    }

    private boolean isCorrectChooseBook(String choice) {
        return (userInput.checkIsStringANumber(choice)) && areThereThatManyBooks(choice);

    }

    private boolean areThereThatManyBooks(String choice) {
        return (Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= bookRepository.getBooks().size());
    }

    public int chooseBookToPrint() {
        stdout.info("\n{}\n", l.getMessageByKey(ENTER_BOOK_NUMBER));
        String choice = scanner.next();

        if (!isCorrectChooseBook(choice)) {
            stdout.info("\n{}\n", l.getMessageByKey(INCORRECT_SELECTION_TRY_AGAIN)) ;
            bookChoice = 0;
            chooseBookToPrint();
        } else {
            bookChoice = Integer.parseInt(choice) - 1;
            return bookChoice;
        }
        return bookChoice;
    }

}


