package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;


public class BookFinder {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static List<Book> BOOKS = BookRepository.getInstance().getBookRepository();

    public void bookFinderSetup(int param, int hasAudio) {

        String author = "";
        String title = "";

        if (param == 1)  {
            stdout.info("\nSzukanie ksiazek po autorze podajac ciag znakow ktory zawiera sie w imieniu lub nazwisku \n");
            List<String> authorslist;
            while (author == "") {
                authorslist = findAuthorByName(getLetters());
                author = verifyFindingAuthor(authorslist);
            }

            printFilteredBooks(param, hasAudio, author, "" );
        }
        if (param == 2)  {
            stdout.info("\nSzukanie ksiazek po tytule podajac ciag znakow ktory zawiera sie w tytule \n ");
            List<String> titleslist;
            while (title == "") {
                titleslist = findTitleByName(getLetters());
                title = verifyFindingAuthor(titleslist);
            }
            printFilteredBooks(param, hasAudio, "", title);
        }
        if (param == 3)  {
            stdout.info("\nSzukanie ksiazek po autorze i tytule podajac najpierw ciag znakow ktory zawiera sie \n w tytule , nastepnie ciag znakow zawierajacy sie w imieniu lub nazwisku autora \n");
            List<String> authorslist;
            while (author == "") {
                authorslist = findAuthorByName(getLetters());
                author = verifyFindingAuthor(authorslist);
            }
            stdout.info("\nTeraz tytul");
            List<String> titleslist;
            while (title == "") {
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

        List <String> authorsList = BOOKS.stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().toLowerCase().contains(letters.toLowerCase()))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        //System.out.println(authorsList);
        //verifyFindingAuthor(authorsList);

        return  authorsList;
    }

    private String verifyFindingAuthor (List<String> authorsList)  {

        //String author = "";

        if (authorsList.isEmpty()) {
            stdout.info("\nNie znaleziono pasujących rekordów, spróbuj ponownie: \n");
            authorsList.removeAll(authorsList);
        } else if (authorsList.size() > 1) {
            stdout.info("\nZnaleziono " + authorsList.size() + " pasujących autorów:\n");
            printList(authorsList);
            stdout.info("\nUściślij swój wybór\n ");
            authorsList.removeAll(authorsList);

        } else {
            //author = authorsList.get(0);
            stdout.info("\nCzy chodzilo ci o " + authorsList.get(0) + " ?  (t - tak) \n");
            Scanner scanner = new Scanner(System.in);
            String yesOrNot = scanner.next();
            if (!yesOrNot.equalsIgnoreCase("t")) {
                stdout.info("\nSprobuj ponownie\n ");
            }  else {
                return authorsList.get(0);
            }
        }


        return "";
    }

    private List<String> findTitleByName(String letters) {

        List<String> titlesList =  BOOKS.stream()
                .filter(b -> b.getTitle() != null)
                .filter(b -> b.getTitle().toLowerCase().contains(letters.toLowerCase()))
                .map(Book::getTitle)
                .distinct()
                .collect(Collectors.toList());

        //verifyFindingTitle(titlesList);

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
            //title = titlesList.get(0);
            stdout.info("\nCzy chodzilo ci o " + titlesList.get(0) + " ?  (t - tak) \n");
            Scanner scanner = new Scanner(System.in);
            String yesOrNot = scanner.next();
            if (!yesOrNot.equalsIgnoreCase("t")) {
                stdout.info("\nSprobuj ponownie\n ");
            }  else {
                return titlesList.get(0);
            }
        }
        return title;
    }

    private void printList (List<String> list) {
        int counter = 1;
        for (String element : list) {
            System.out.println(counter + ". " + element);
            counter++;

        }
        return;
    }

    private void printFilteredBooks(int searchingMethod, int hasAudio, String author, String title) {

        List<Book> filteredBooks = BOOKS;

        if (hasAudio == 1)  {
            filteredBooks = filteredBooks.stream()
                    .filter(b -> b.isHasAudio())
                    .collect(Collectors.toList());
        }
        if (hasAudio == 2)  {
            filteredBooks = filteredBooks.stream()
                    .filter(b -> !b.isHasAudio())
                    .collect(Collectors.toList());
        }

        if (searchingMethod == 1) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

            filteredBooks.forEach(System.out::println);

        } else if (searchingMethod == 2) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .collect(Collectors.toList());

            filteredBooks.forEach(System.out::println);

        } else if (searchingMethod == 3) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

            filteredBooks.forEach(System.out::println);
        }
        if (filteredBooks.isEmpty())      {
            stdout.info("\nBrak książek spełniających kryteria");
        }

    }

    public static void main(String[] args) {

        new BookFinder().bookFinderSetup(3, 1);
    }
}


