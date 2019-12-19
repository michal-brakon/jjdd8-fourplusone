package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class BookAdder {

    private Scanner scanner = new Scanner(System.in);
    private Book book = new Book();
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void addBook() {
        ManageBooks idChecker = new ManageBooks();
        book.setId(idChecker.getSequenceId());
        stdout.info("Podaj rodzaj\n");
        String kind = scanner.next();
        book.setKind(kind);
        stdout.info("Podaj autora\n");
        String author = scanner.next();
        book.setAuthor(author);
        stdout.info("Podaj epoke\n");
        String epoch = scanner.next();
        book.setEpoch(epoch);
        stdout.info("Podaj tytuł \n");
        String title = scanner.next();
        book.setTitle(title);
        stdout.info("Podaj rodzaj literacki \n");
        String genre = scanner.next();
        book.setGenre(genre);
        stdout.info("Czy ma audio t/n :");
        boolean audio = checkChoice();
        book.setHasAudio(audio);
        BookRepository.getInstance().getBooks().add(book);


    }

    public boolean checkChoice() {
        String checkChoice;
        checkChoice = scanner.next().toLowerCase();
        if (checkChoice.equals("t")) {
            return true;
        } else if (checkChoice.equals("n")) {
            return false;
        } else {
            stdout.info("Źle wprowadziłeś");
            checkChoice();
        }
        return false;
    }
}
