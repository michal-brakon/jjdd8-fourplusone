package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;
import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import com.infoshareacademy.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class DeleteBook {


    private Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private ManageBooks manageBooks = new ManageBooks();
    Language l = new Language();

    public void deleteBook() {
        stdout.info(l.getMessageByKey(LangKeyConfig.ID_OF_BOOK_TO_DELETE) ,"\n");
        String s = scanner.next();
        Long id = 0L;
        if(s.equalsIgnoreCase("q")){return;}
        UserInput userInput = new UserInput();
        if (userInput.checkIsStringANumber(s)) {
            id = Long.parseLong(s);
        } else {
            stdout.info(l.getMessageByKey(LangKeyConfig.INCORRECT_SELECTION_TRY_AGAIN) ,"\n");
            deleteBook();
        }
        Book book = manageBooks.findBookById(id);


        if (book == null) {
            stdout.info(l.getMessageByKey(LangKeyConfig.NO_BOOK_THIS_ID) ,"\n");
            deleteBook();
        }
        stdout.info(l.getMessageByKey(LangKeyConfig.CHOSEN_BOOK), "\n{}", book);
        stdout.info(l.getMessageByKey(LangKeyConfig.SURE_TO_DEL) ,"\n");
        String t = scanner.next().toLowerCase();

        if (t.equals(l.getMessageByKey(LangKeyConfig.Y))) {
            BookRepository.getInstance().getBooks().remove(book);
            stdout.info(l.getMessageByKey(LangKeyConfig.DELETED) ,"\n");
        } else if (t.equals(l.getMessageByKey(LangKeyConfig.Y))) {
          deleteBook();
        }


    }

}
