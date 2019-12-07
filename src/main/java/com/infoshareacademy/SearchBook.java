package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SearchBook {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void searchFromAuthor() {
        stdout.info("Podaj nazwisko autora książki\n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toLowerCase();


        for (Book book : BookRepository.getBooks()) {
            if (book.getAuthor().toLowerCase().contains(choice)) {
                stdout.info(String.valueOf(book));

            } else {
                stdout.info("Nie ma takiego autora   \n");
                stdout.info("Feature in progress \n");

                stdout.info("\n Nacisnij dowolny klawisz aby kontynuawać\n");

                choice = scanner.next();
                if (choice != null)
                    //new Menu().bookListMenu();
                break;

            }

        }
       // new Menu().bookListMenu();


    }


}
