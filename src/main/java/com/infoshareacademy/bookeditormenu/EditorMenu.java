package com.infoshareacademy.bookeditormenu;

import com.infoshareacademy.Book;
import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
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
    Language l = new Language();

    public void bookEditorMenu() {


        ScreenCleaner.clearScreen();


        stdout.info(l.getMessageByKey(LangKeyConfig.ENTER_ID_BOOK), "\n");


        String s = scanner.next();
        Long id = 0L;
        UserInput userInput = new UserInput();
        if (userInput.checkIsStringANumber(s)) {
            id = Long.parseLong(s);
        } else {
            stdout.info(l.getMessageByKey(LangKeyConfig.YOU_ENTER_INCORRECT), "\n");
            bookEditorMenu();
        }
        Book book = manageBooks.findBookById(id);
        if (book == null) {
            stdout.info(l.getMessageByKey(LangKeyConfig.NO_BOOK_THIS_ID), "\n");
            bookEditorMenu();
        } else {
            stdout.info(l.getMessageByKey(LangKeyConfig.CHOSEN_BOOK), "\n {}\n ", book);
        }

        stdout.info("\n", l.getMessageByKey(LangKeyConfig.WHAT_TO_EDIT));
        stdout.info("\n", l.getMessageByKey(LangKeyConfig.AUT));
        stdout.info("\n", l.getMessageByKey(LangKeyConfig.TIT));
        stdout.info("\n", l.getMessageByKey(LangKeyConfig.KIN));
        stdout.info("\n", l.getMessageByKey(LangKeyConfig.GEN));
        stdout.info("\n", l.getMessageByKey(LangKeyConfig.AUD));
        stdout.info("\n", l.getMessageByKey(LangKeyConfig.EPO));
        stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.AUT));
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                stdout.info( l.getMessageByKey(LangKeyConfig.PROVIDED_AUTHOR),"\n");
                String author = scanner.next();
                manageBooks.modifyAuthor(author, id);
                stdout.info(l.getMessageByKey(LangKeyConfig.AUTHOR_CHANGED));
                break;
            case 2:
                stdout.info( l.getMessageByKey(LangKeyConfig.PROV_TITLE),"\n");
                String title = scanner.next();
                manageBooks.modifyTitle(title, id);
                stdout.info(l.getMessageByKey(LangKeyConfig.TITLE_CHANGED));
                break;
            case 3:
                stdout.info( l.getMessageByKey(LangKeyConfig.PROV_KIND),"\n");
                String kind = scanner.next();
                manageBooks.modifyKind(kind, id);
                stdout.info(l.getMessageByKey(LangKeyConfig.KIND_CHANGED));
                break;
            case 4:
                stdout.info( l.getMessageByKey(LangKeyConfig.PROV_GENRE),"\n");
                String genre = scanner.next();
                manageBooks.modifyGenre(genre, id);
                stdout.info(l.getMessageByKey(LangKeyConfig.GENRE_CHANGED));
                break;
            case 5:
                stdout.info( l.getMessageByKey(LangKeyConfig.PROV_AUDIO),"\n");
                boolean check = new BookAdder().checkChoice();
                manageBooks.modifyHasAudio(check, id);
                stdout.info(l.getMessageByKey(LangKeyConfig.AUDIO_CHANGED));
                break;
            case 6:
                stdout.info( l.getMessageByKey(LangKeyConfig.PROV_EPOCH),"\n");
                String epoch = scanner.next();
                manageBooks.modifyEpoch(epoch, id);
                stdout.info(l.getMessageByKey(LangKeyConfig.EPOCH_CHANGED));
                break;

            case 0:
                return;
            default:
                break;

        }

    }
}



