package com.infoshareacademy;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Search {

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

        List<String> authors = new ArrayList<>();

        List<Book> booksVerified = BOOKS.stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().contains(letters))
                .filter(b -> !(authors.contains(b.getAuthor())))
                .distinct()
                .collect(Collectors.toList());

        booksVerified.forEach(b -> authors.add(b.getAuthor()));

        if (authors.isEmpty()) {
            System.out.println("Nie znaleziono pasujących rekordów, spróbuj ponownie: ");
            //TODO wywołanie metody
        } else if (authors.size() > 1)  {
            System.out.println("Znaleziono "+ authors.size() + " pasujących autorów: ");
            for (String author : authors) {
                int counter;
                System.out.println(counter);
            }
        }




        return null;
    }

    public static void main (String[]args)  {

        Search search = new Search();

        System.out.println(search.getAuthors(BOOKS, search.getLetters()));

        }
    }


