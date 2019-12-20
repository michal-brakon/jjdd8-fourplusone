package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;
import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class BookAdder {

    private Scanner scanner = new Scanner(System.in);
    private Book book = new Book();
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    Language l = new Language();

    public void addBook() {
        ManageBooks idChecker = new ManageBooks();
        book.setId(idChecker.getSequenceId());
        stdout.info(l.getMessageByKey(LangKeyConfig.PROV_KIND) ,"\n");
        String kind = scanner.next();
        book.setKind(kind);
        stdout.info(l.getMessageByKey(LangKeyConfig.PROVIDED_AUTHOR) ,"\n");
        String author = scanner.next();
        book.setAuthor(author);
        stdout.info(l.getMessageByKey(LangKeyConfig.PROV_EPOCH) ,"\n");
        String epoch = scanner.next();
        book.setEpoch(epoch);
        stdout.info(l.getMessageByKey(LangKeyConfig.PROV_TITLE) ,"\n");
        String title = scanner.next();
        book.setTitle(title);
        stdout.info(l.getMessageByKey(LangKeyConfig.PROV_GENRE) ,"\n");
        String genre = scanner.next();
        book.setGenre(genre);
        stdout.info(l.getMessageByKey(LangKeyConfig.PROV_AUDIO) ,"\n");
        boolean audio = checkChoice();
        book.setHasAudio(audio);
        BookRepository.getInstance().getBooks().add(book);
        stdout.info(l.getMessageByKey(LangKeyConfig.BOOK_ADDED) ,"\n");

    }

    public boolean checkChoice() {
        String checkChoice;
        checkChoice = scanner.next().toLowerCase();
        if (checkChoice.equals(l.getMessageByKey(LangKeyConfig.Y))) {
            return true;
        } else if (checkChoice.equals(l.getMessageByKey(LangKeyConfig.N))) {
            return false;
        } else {
            stdout.info(l.getMessageByKey(LangKeyConfig.YOU_ENTER_INCORRECT));
            checkChoice();
        }
        return false;
    }
}
