package com.infoshareacademy;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Search {

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

    

    private Set<String> getAuthors(List<Book> books) {

        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }


        return authors;
    }
    private List<String> getAuthorsContainsLetters (String letters)  {

        //Set<String> collect = getAuthors(BookRepository.getInstance().getBookRepository());

        List<String> authorsContainsLetters = getAuthors(BookRepository.getInstance().getBookRepository()).stream()
                .filter(c -> c.contains(letters))
                .collect(Collectors.toList());

        if (authorsContainsLetters.size() > 1) {
            System.out.println(authorsContainsLetters);
            System.out.println("Proszę uściślić wybór: ");
            System.out.println(getAuthorsContainsLetters(getLetters()));
        }

        return authorsContainsLetters;
    }

    public static void main (String[]args)  {


        Search search = new Search();

        System.out.println(search.getAuthorsContainsLetters(search.getLetters()));

        }
    }


