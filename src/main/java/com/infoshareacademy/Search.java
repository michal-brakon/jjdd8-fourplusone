package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Search {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    static List<Book> BOOKS = BookRepository.getInstance().getBookRepository();

    private String getLetters() {

        Scanner scanner = new Scanner(System.in);
        String letters = "";
        while (letters.length() < 3) {

            System.out.println("Wpisz conajmniej 3 znakowy ciąg znaków: ");
            letters = scanner.next();
        }
        return letters;
    }

    

    private String getAuthors(String letters) {

        Set<String> authorsSet = new TreeSet<>();
        List<String> authorsList = new ArrayList<>();
        String author = "";

        List<Book> booksContainsLetters = BOOKS.stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().contains(letters))
                .filter(b -> !(authorsSet.contains(b.getAuthor())))
                .distinct()
                .collect(Collectors.toList());

        booksContainsLetters.forEach(b -> authorsSet.add(b.getAuthor()));

        authorsList.addAll(authorsSet);

        if (authorsList.isEmpty()) {
            System.out.println("Nie znaleziono pasujących rekordów, spróbuj ponownie: ");
            getAuthors(getLetters());
        } else if (authorsList.size() > 1)  {
            System.out.println("Znaleziono "+ authorsSet.size() + " pasujących autorów: ");
            printAuthorsList(authorsList);
            System.out.println("Uściślij swój wybór");
            getAuthors(getLetters());
        } else {
            author = authorsList.get(0);
            System.out.println("Czy chodzilo ci o " + author + " ?  (t - tak)");
            Scanner scanner = new Scanner(System.in);
            String yesOrNot = scanner.next();
                if (!yesOrNot.equalsIgnoreCase("t")) {
                    System.out.println("Sprobuj ponownie ");
                    getAuthors(getLetters());
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
                .filter(b -> b != null)
                .filter(b -> b.getAuthor().equals(authors))
                .collect(Collectors.toList());

        filteredBooks.forEach(System.out::println);
    }



    public static void main (String[]args)  {

        Search search = new Search();
        String author = search.getAuthors(search.getLetters());
        System.out.println(author);
        search.printFilteredBooks(author);
        }
    }


