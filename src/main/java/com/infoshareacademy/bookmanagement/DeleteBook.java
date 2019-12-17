package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;
import com.infoshareacademy.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class DeleteBook {



        private Scanner scanner = new Scanner(System.in);
        private Book book = new Book();
        private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
        private UserInput userInput = new UserInput();

        public Book bookFinder(Long id){
            return BookRepository.getInstance().getBooks().stream()
                    .filter(i -> i.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        public void deletebook(){

            stdout.info("podaj id książki którą chcesz usunąć: \n");

           Long id=0L;
            book= bookFinder(id);
            BookRepository.getInstance().getBooks().remove(book);
    }

}
