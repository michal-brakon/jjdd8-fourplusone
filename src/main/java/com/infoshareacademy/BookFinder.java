package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BookFinder {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static List<Book> BOOKS = BookRepository.getInstance().getBooks();

    public void bookFinderSetup(int param, int hasAudio) {

        String author = "";
        String title = "";

        if (param == 1) {
            stdout.info("\nSzukanie książek po autorze podając ciąg znaków który zawiera się w imieniu lub nazwisku \n");
            List<String> authorslist;
            while (author.isEmpty()) {
                authorslist = findAuthorByName(getLetters());
                author = verifyFindingAuthor(authorslist);
            }

            printFilteredBooks(param, hasAudio, author, "");
        }
        if (param == 2) {
            stdout.info("\nSzukanie ksiązek po tytule podając ciag znaków który zawiera się w tytule \n ");
            List<String> titleslist;
            while (title.isEmpty()) {
                titleslist = findTitleByName(getLetters());
                title = verifyFindingAuthor(titleslist);
            }
            printFilteredBooks(param, hasAudio, "", title);
        }
        if (param == 3) {
            stdout.info("\nSzukanie książek po autorze i tytule podając najpierw ciąg znaków który zawiera się \n w tytule , następnie ciąg znaków zawierający się w imieniu lub nazwisku autora \n");
            List<String> authorslist;
            while (author.isEmpty()) {
                authorslist = findAuthorByName(getLetters());
                author = verifyFindingAuthor(authorslist);
            }
            stdout.info("\nTeraz tytuł ");
            List<String> titleslist;
            while (title.isEmpty()) {
                titleslist = findTitleByName(getLetters());
                title = verifyFindingTitle(titleslist);
            }
            printFilteredBooks(param, hasAudio, author, title);
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

        List<String> authorsList = BOOKS.stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().toLowerCase().contains(letters.toLowerCase()))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        return authorsList;
    }

    private String verifyFindingAuthor(List<String> authorsList) {

        if (authorsList.isEmpty()) {
            stdout.info("\nNie znaleziono pasujących rekordów, spróbuj ponownie: \n");
        } else if (authorsList.size() > 1) {
            stdout.info("\nZnaleziono " + authorsList.size() + " pasujących autorów:\n");
            printList(authorsList);
            stdout.info("\nUściślij swój wybór\n ");
            authorsList.removeAll(authorsList);
        } else {
            stdout.info("\nCzy chodziło ci o " + authorsList.get(0) + " ?  (t - tak) \n");
            Scanner scanner = new Scanner(System.in);
            String confirmationType = scanner.next();
            if (!confirmationType.equalsIgnoreCase("t")) {
                stdout.info("\nSpróbuj ponownie\n ");
            } else {
                return authorsList.get(0);
            }
        }

        return "";
    }

    private List<String> findTitleByName(String letters) {

        List<String> titlesList = BOOKS.stream()
                .filter(b -> b.getTitle() != null)
                .filter(b -> b.getTitle().toLowerCase().contains(letters.toLowerCase()))
                .map(Book::getTitle)
                .distinct()
                .collect(Collectors.toList());

        return titlesList;
    }

    private String verifyFindingTitle(List<String> titlesList) {

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
            stdout.info("\nCzy chodziło ci o " + titlesList.get(0) + " ?  (t - tak) \n");
            Scanner scanner = new Scanner(System.in);
            String confirmationType = scanner.next();
            if (!confirmationType.equalsIgnoreCase("t")) {
                stdout.info("\nSpróbuj ponownie\n ");
            } else {
                return titlesList.get(0);
            }
        }
        return title;
    }

    private void printList(List<String> list) {
        int counter = 1;
        for (String element : list) {
            stdout.info(counter + ". " + element);
            counter++;

        }
        return;
    }

    private void printFilteredBooks(int searchingMethod, int hasAudio, String author, String title) {

        List<Book> filteredBooks = BOOKS;

        if (hasAudio == 1) {
            filteredBooks = filteredBooks.stream()
                    .filter(b -> b.isHasAudio())
                    .collect(Collectors.toList());
        }
        if (hasAudio == 2) {
            filteredBooks = filteredBooks.stream()
                    .filter(b -> !b.isHasAudio())
                    .collect(Collectors.toList());
        }

        if (searchingMethod == 1) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

            filteredBooks.forEach(x -> stdout.info(String.valueOf(x)));

        } else if (searchingMethod == 2) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .collect(Collectors.toList());

            filteredBooks.forEach(x -> stdout.info(String.valueOf(x)));

        } else if (searchingMethod == 3) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

            filteredBooks.forEach(x -> stdout.info(String.valueOf(x)));
        }
        if (filteredBooks.isEmpty()) {
            stdout.info("\nBrak książek spełniających kryteria");
        }
    }
}


