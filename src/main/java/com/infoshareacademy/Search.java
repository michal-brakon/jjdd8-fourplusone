package com.infoshareacademy;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.regex.Pattern;

public class Search {

    static Set<String> authors = new HashSet<>();
    private static int authorCount = 0;

    private String getLetters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz: ");
        String letters = scanner.next();
        return letters;
    }

    private Set<String> searchAuthors(List<Book> books) {

        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    public static void main(String[] args) {

        String wybor = new Search().getLetters();
        new Search().searchAuthors(BookRepository.getInstance().getBookRepository());

        for(String author : new Search().searchAuthors(BookRepository.getInstance().getBookRepository())) {
            if (author.contains(wybor)) {
                System.out.println(author);
                authorCount++;
            }
        }
        System.out.println(authorCount);
    }
}

