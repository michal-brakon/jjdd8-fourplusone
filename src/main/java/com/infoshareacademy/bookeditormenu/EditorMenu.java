package com.infoshareacademy.bookeditormenu;

import com.infoshareacademy.Book;
import com.infoshareacademy.ScreenCleaner;
import com.infoshareacademy.UserInput;
import com.infoshareacademy.bookmanagement.BookAdder;
import com.infoshareacademy.bookmanagement.ManageBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class EditorMenu {


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
        Book book = manageBooks.findBookById(id);
        if (book == null) {
            stdout.info("nie ma książki o takim id! \n ");
            bookEditorMenu();
        } else {
            stdout.info("Wybrana przez Ciebie książka to : \n {}\n ", book);
        }

        stdout.info("\n   Co chcesz edytować?: ");
        stdout.info("\n1.   autora");
        stdout.info("\n2.   tytuł");
        stdout.info("\n3.   rodzaj");
        stdout.info("\n4.   gatunek literacki");
        stdout.info("\n5.   wersje audio");
        stdout.info("\n6.   epoka");
        stdout.info("\n0.   wyjscie\n");
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                stdout.info(" Podaj autora \n");
                String author = scanner.next();
                manageBooks.modifyAuthor(author, id);
                stdout.info("Autor został zmieniony ");
                break;
            case 2:
                stdout.info(" Podaj tytuł ");
                String title = scanner.next();
                manageBooks.modifyTitle(title, id);
                stdout.info("Tytuł został zmieniony ");
                break;
            case 3:
                stdout.info(" Podaj rodzaj ");
                String kind = scanner.next();
                manageBooks.modifyKind(kind, id);
                stdout.info("Rodzaj został zmieniony ");
                break;
            case 4:
                stdout.info(" Podaj Gatunek literacki");
                String genre = scanner.next();
                manageBooks.modifyGenre(genre, id);
                stdout.info("Gatunek literacki został zmieniony ");
                break;
            case 5:
                stdout.info(" Podaj, wersja audio T/N ");
                boolean check = new BookAdder().audioChanger();
                manageBooks.modifyHasAudio(check, id);
                stdout.info("czy ma Audio zostało zmienione ");
                break;
            case 6:
                stdout.info(" Podaj epoke ");
                String epoch = scanner.next();
                manageBooks.modifyEpoch(epoch, id);
                stdout.info("Epoka została zmieniona ");
                break;

            case 0:
                return;
            default:
                break;

        }

    }
}



