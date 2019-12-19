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

    private ManageBooks manageBooks=new ManageBooks();

    public void deleteBook() {
        stdout.info("podaj id książki którą chcesz usunąć: \n");
        String s = scanner.next();
        Long id = 0L;
        UserInput userInput = new UserInput();
        if (userInput.isANumber(s)) {
            id = Long.parseLong(s);
        } else {
            stdout.info("źle wpisałeś spróbuj ponownie\n");
            deleteBook();
        }

        Book  book = manageBooks.findBookById(id);

        BookRepository.getInstance().getBooks().remove(book);
    }

}
