package com.infoshareacademy;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Search {

    final static List<Book> BOOKS = BookRepository.getInstance().getBookRepository();

    //Search search = new Search();

    private String getLetters() {

        Scanner scanner = new Scanner(System.in);
        String letters = "";
        while (letters.length() < 3) {

            System.out.println("Wpisz conajmniej 3 znakowy ciąg znaków: ");
            letters = scanner.next();
        }
        return letters;
    }

    

    private String getAuthors(List<Book> books, String letters) {

        List<String> authors = new ArrayList<>();
        String author = "";




        List<Book> sortedBooks = books.stream()
                .filter(book -> book.getAuthor() != null && book.getAuthor().contains(letters))
                .collect(Collectors.toList());

        for (Book book : sortedBooks) {
           if (!authors.contains(book.getAuthor())) {
               authors.add(book.getAuthor());
           }
        }

        if (authors.size() > 1) {
            System.out.println(authors);
            System.out.println("Proszę uściślić wybór: ");
            getLetters();
        }  else if (authors.size() == 0) {
            System.out.println("Nie znaleziono pasujacego autora! ");
            getLetters();
        }  else if (authors.size() == 1) {
            author = authors.get(0);
        }

        return author;
    }

    private String chooseCorrectAuthor (Set<String> authors)  {

        String author = "";

//        if (authors.size() > 1) {
//            System.out.println(authors);
//            System.out.println("Proszę uściślić wybór: ");
//            getLetters();
//        }  else if (authors.size() == 0) {
//            System.out.println("Nie znaleziono pasujacego autora! ");
//            getLetters();
//        }

        return author;
    }

    public static void main (String[]args)  {

        Search search = new Search();

        System.out.println(search.getAuthors(BOOKS, search.getLetters()));

        }
    }


