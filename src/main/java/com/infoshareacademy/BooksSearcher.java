package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;


public class BooksSearcher {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static List<Book> BOOKS = BookRepository.getInstance().getBookRepository();

    private void bookFinderSetup(int param) {

        String author;
        String title;

        if (param == 1)  {
            stdout.info("\nSzukanie ksiazek po autorze podajac ciag znakow ktory zawiera sie w imieniu lub nazwisku \n");
            List<String> authorsList = findAuthorByName(getLetters());
            //author = verifyFindingAuthor(authorsList);
            printFilteredBooks(1, verifyFindingAuthor(authorsList), "" );
        }
        if (param == 2)  {
            stdout.info("\nSzukanie ksiazek po tytule podajac ciag znakow ktory zawiera sie w tytule \n ");
            List<String> titlesList = findTitleByName(getLetters());
            title = verifyFindingTitle(titlesList);
            printFilteredBooks(2, "", title);
        }
        if (param == 3)  {
            stdout.info("\nSzukanie ksiazek po autorze i tytule podajac najpierw ciag znakow ktory zawiera sie \n w tytule , nastepnie ciag znakow zawierajacy sie w imieniu lub nazwisku autora \n");

            List<String> authorsList = findAuthorByName(getLetters());
            //author = verifyFindingAuthor(authorsList);
            stdout.info("\nTeraz tytul");
            List<String> titlesList = findTitleByName(getLetters());
            title = verifyFindingTitle(titlesList);

            printFilteredBooks(3, verifyFindingAuthor(authorsList), verifyFindingTitle(titlesList));
        }
    }

    private String getLetters() {

        Scanner scanner = new Scanner(System.in);
        String letters = "";
        while ((letters.length() < 3) && (!letters.contains(" "))) {

            stdout.info("\nWpisz conajmniej 3 znakowy ciąg liter: \n ");
            letters = scanner.next();
        }
        return letters;
    }



    private List<String> findAuthorByName(String letters) {

        List <String> authorsList = BOOKS.stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().contains(letters))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        verifyFindingAuthor(authorsList);

        return  authorsList;
    }

    private String verifyFindingAuthor (List<String> authorsList)  {

        String author = "";

        if (authorsList.isEmpty()) {
            stdout.info("\nNie znaleziono pasujących rekordów, spróbuj ponownie: \n");
            findAuthorByName(getLetters());
        } else if (authorsList.size() > 1) {
            stdout.info("\nZnaleziono " + authorsList.size() + " pasujących autorów:\n");
            printList(authorsList);
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

    private List<String> findTitleByName(String letters) {

        List<String> titlesList =  BOOKS.stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().contains(letters))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        verifyFindingTitle(titlesList);

        return titlesList;
    }

    private String verifyFindingTitle (List<String> titlesList)  {

        String title = "";

        if (titlesList.isEmpty()) {
            stdout.info("\nNie znaleziono pasujących rekordów, spróbuj ponownie: \n");
            findTitleByName(getLetters());
        } else if (titlesList.size() > 1) {
            stdout.info("\nZnaleziono " + titlesList.size() + " pasujących autorów: ");
            printList(titlesList);
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

    private static void printList (List<String> list) {
        int counter = 1;
        for (String element : list) {
            System.out.println(counter + ". " + element);
            counter++;
        }
    }

    private void printFilteredBooks(int searchingMethod, String author, String title) {

        if (searchingMethod == 1) {
            List<Book> filteredBooks = BOOKS.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

            filteredBooks.forEach(System.out::println);

        } else if (searchingMethod == 2) {
            List<Book> filteredBooks = BOOKS.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .collect(Collectors.toList());

            filteredBooks.forEach(System.out::println);
        } else if (searchingMethod == 3) {
            List<Book> filteredBooks = BOOKS.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

        }

    }

    public static void main(String[] args) {

        new BooksSearcher().bookFinderSetup(1);
    }
}


