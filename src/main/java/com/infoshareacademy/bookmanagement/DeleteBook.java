package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;
import com.infoshareacademy.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class DeleteBook {


    private Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private ManageBooks manageBooks = new ManageBooks();

    public void deleteBook() {
        stdout.info("podaj id książki którą chcesz usunąć, lub q żeby przerwać\n");
        String s = scanner.next();
        Long id = 0L;
        if (s.equalsIgnoreCase("q")) {
            return;
        }
        UserInput userInput = new UserInput();
        if (userInput.checkIsStringANumber(s)) {
            id = Long.parseLong(s);
        } else {
            stdout.info("źle wpisałeś spróbuj ponownie\n");
            deleteBook();
        }
        Book book = manageBooks.findBookById(id);


        if (book == null) {
            stdout.info("nie ma książki o takim id! \n ");
            deleteBook();
        }
        stdout.info("Książka którą chcesz usunać to:\n{}", book);
        stdout.info("Czy na pewno chcesz usunąć T/N?\n");
        String t = scanner.next().toLowerCase();

        if (t.equals("t")) {
            BookRepository.getInstance().getBooks().remove(book);
            stdout.info("pozycja została usunięta \n");
        } else if (t.equals("n")) {
            deleteBook();
        }


    }

}
