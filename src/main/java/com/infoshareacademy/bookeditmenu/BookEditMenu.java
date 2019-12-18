package com.infoshareacademy.bookeditmenu;

import com.infoshareacademy.ScreenCleaner;
import com.infoshareacademy.UserInput;
import com.infoshareacademy.bookmanagement.ManageBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class BookEditMenu {


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private Scanner scanner = new Scanner(System.in);
    private ManageBooks manageBooks = new ManageBooks();

    public void bookEditorMenu() {

        ScreenCleaner.clearScreen();



        stdout.info("Podaj id książki : \n");


        String s = scanner.next();
        Long id = 0L;
        UserInput userInput = new UserInput();
        if (userInput.isANumber(s)) {
            id = Long.parseLong(s);
        } else {
            stdout.info("źle wpisałeś spróbuj ponownie\n");
            bookEditorMenu();
        }
        manageBooks.findBookById(id);

        stdout.info("\n   Edytuj: ");
        stdout.info("\n1. po autorze");
        stdout.info("\n2. po tytule");
        stdout.info("\n3. po rodzaju");
        stdout.info("\n4. po gatunku literackim");
        stdout.info("\n0. wyjscie\n");
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                stdout.info(" Podaj autora książki");
                String author = scanner.next();
                manageBooks.modifiesByAuthor(author, id);
                break;
            case 0:
                return;

        }

    }
}



