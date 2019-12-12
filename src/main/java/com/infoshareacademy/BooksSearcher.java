package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;


public class BooksSearcher {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static List<Book> BOOKS = BookRepository.getInstance().getBookRepository();

    private int chooseSearchingMethod () {

        List<String> searchingLetters = new ArrayList<>();

        stdout.info("\nWybierz metode wyszukiwania: ");
        stdout.info("\n1. Tylko po autorze");
        stdout.info("\n2. Tylko po tytule");
        stdout.info("\n3. Po tytule i autorze");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        int searchingMethod = Integer.valueOf(choice);
        if (searchingMethod == 1)  {
            stdout.info("Szukanie po autorze: ");
            findAuthorByName(getLetters());
        } else if (searchingMethod == 2)  {
            stdout.info("\nSzukanie po tytule: ");
            findTitleByName(getLetters());
        } else if (searchingMethod == 3)  {
            stdout.info("\nSzukanie po autorze i tytule");
            stdout.info("\nSzukaj autora: ");
            stdout.info("\nSzukaj autora: ");
            findAuthorByName(getLetters());
            stdout.info("\nSzukaj tytulu: ");
            findTitleByName(getLetters());
;        }
        return searchingMethod;
    }

    private String getLetters() {

        Scanner scanner = new Scanner(System.in);
        String letters = "";
        while ((letters.length() < 3) && (!letters.contains(" "))) {

            stdout.info("\nWpisz conajmniej 3 znakowy ciąg liter: ");
            letters = scanner.next();
        }
        return letters;
    }

    private String findAuthorByName(String letters) {

        String author = "";

        List<String> authorsList = BookRepository.getInstance().getBookRepository().stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().contains(letters))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        if (authorsList.isEmpty()) {
            stdout.info("\nNie znaleziono pasujących rekordów, spróbuj ponownie: \n");
            findAuthorByName(getLetters());
        } else if (authorsList.size() > 1)  {
            stdout.info("\nZnaleziono "+ authorsList.size() + " pasujących autorów: ");
            printAuthorsList(authorsList);
            stdout.info("\nUściślij swój wybór\n ");
            findAuthorByName(getLetters());
        } else {
            author = authorsList.get(0);
            stdout.info("\nCzy chodzilo ci o " + author + " ?  (t - tak) \n");
            Scanner scanner = new Scanner(System.in);
            String yesOrNot = scanner.next();
                if (!yesOrNot.equalsIgnoreCase("t")) {
                    stdout.info("\nSprobuj ponownie\n ");
                    findAuthorByName(getLetters());
                }
        }
      return author;
    }

    private String findTitleByName(String letters) {

        String title = "";

        List<String> titlesList = BookRepository.getInstance().getBookRepository().stream()
                .filter(b -> b.getTitle() != null)
                .filter(b -> b.getTitle().contains(letters))
                .map(Book::getTitle)
                .distinct()
                .collect(Collectors.toList());

        if (titlesList.isEmpty()) {
            stdout.info("\nNie znaleziono pasujących rekordów, spróbuj ponownie: \n");
            findTitleByName(getLetters());
        } else if (titlesList.size() > 1)  {
            stdout.info("\nZnaleziono "+ titlesList.size() + " pasujących autorów: ");
            printAuthorsList(titlesList);
            stdout.info("\nUściślij swój wybór\n ");
            findTitleByName(getLetters());
        } else {
            title = titlesList.get(0);
            stdout.info("\nCzy chodzilo ci o " + title + " ?  (t - tak) \n");
            Scanner scanner = new Scanner(System.in);
            String yesOrNot = scanner.next();
            if (!yesOrNot.equalsIgnoreCase("t")) {
                stdout.info("\nSprobuj ponownie\n ");
                findTitleByName(getLetters());
            }
        }
        return title;
    }

    private static void printAuthorsList(List<String> list) {
        int counter = 1;
        for (String author : list) {
            System.out.println(counter + ". " + author);
            counter++;
        }
    }

    private void printFilteredBooks (int searchingMethod, String author, String title) {

        if (searchingMethod == 1) {
            List<Book> filteredBooks = BOOKS.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

            filteredBooks.forEach(System.out::println);

        }  else if (searchingMethod == 2)  {
            List<Book> filteredBooks = BOOKS.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .collect(Collectors.toList());

            filteredBooks.forEach(System.out::println);
        } else if (searchingMethod == 3)   {
            List<Book> filteredBooks = BOOKS.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());
        }
    }

}


