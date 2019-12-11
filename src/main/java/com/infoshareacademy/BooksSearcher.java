package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;


public class BooksSearcher {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static List<Book> BOOKS = BookRepository.getInstance().getBookRepository();

    private String getLetters() {

        Scanner scanner = new Scanner(System.in);
        String letters = "";
        while (letters.length() < 3) {

            stdout.info("\nWpisz conajmniej 3 znakowy ciąg liter: ");
            letters = scanner.next();
        }
        return letters;
    }

    private String getAuthor (String letters) {

        String author = "";

        List<String> authorsList = BookRepository.getInstance().getBookRepository().stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().contains(letters))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        if (authorsList.isEmpty()) {
            stdout.info("\nNie znaleziono pasujących rekordów, spróbuj ponownie: \n");
            getAuthor(getLetters());
        } else if (authorsList.size() > 1)  {
            stdout.info("\nZnaleziono "+ authorsList.size() + " pasujących autorów: ");
            printAuthorsList(authorsList);
            stdout.info("\nUściślij swój wybór\n ");
            getAuthor(getLetters());
        } else {
            author = authorsList.get(0);
            stdout.info("\nCzy chodzilo ci o " + author + " ?  (t - tak) \n");
            Scanner scanner = new Scanner(System.in);
            String yesOrNot = scanner.next();
                if (!yesOrNot.equalsIgnoreCase("t")) {
                    stdout.info("\nSprobuj ponownie\n ");
                    getAuthor(getLetters());
                }
        }
      return author;
    }
    private static void printAuthorsList(List<String> list) {
        int counter = 1;
        for (String author : list) {
            System.out.println(counter + ". " + author);
            counter++;
        }
    }

    private void printFilteredBooks (String authors) {

        List<Book> filteredBooks = BOOKS.stream()
                .filter(Objects::nonNull)
                .filter(b -> b.getAuthor().equals(authors))
                .collect(Collectors.toList());

        filteredBooks.forEach(System.out::println);
    }

}


