package com.infoshareacademy;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Search {

    static Set<String> authors = new HashSet<>();
    private static int authorCount = 0;
    static Set<String> books = new Search().searchAuthors(BookRepository.getInstance().getBookRepository());

    private String getLetters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz: ");
        String letters = scanner.next();
        return letters;
    }

    static private Set<String> searchAuthors(List<Book> books) {

        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }

        Set<String> collect = authors.stream()
                .filter(author -> author.contains(getLetters()))
                .collect(Collectors.toSet());

        return collect;

    }
        public static void main (String[]args){

            System.out.println(new Search().searchAuthors(books));

        }
    }


