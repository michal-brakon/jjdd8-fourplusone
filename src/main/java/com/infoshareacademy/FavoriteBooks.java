package com.infoshareacademy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FavoriteBooks {

    //private static List<Book> BOOKS = BookRepository.getInstance().getBooks();

    public List<String> getFavouritesFromFile() throws IOException {
        File file = new File("favourites.txt");
            if (!file.isFile()) {
                System.out.println("Błąd odczytu pliku");
                return Collections.emptyList();
            }

        List<String> favouriteTitles = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            favouriteTitles.add(scanner.nextLine());
        }

        return favouriteTitles;
    }
    public void addToFavourites (String title) throws IOException {

        if (getFavouritesFromFile().size() < 3) {
            FileWriter file = new FileWriter("favourites.txt", true);
            BufferedWriter out = new BufferedWriter(file);
            out.write("\n" + title);
            out.close();
        }
    }
    public void removeFromFavourites (String title) throws IOException {

        File file = new File("favourites.txt");
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(title))
                .peek(line -> System.out.println(line))
                .collect(Collectors.toList());


        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void main(String[] args) throws IOException {
        new FavoriteBooks().addToFavourites("lineContent");
        new FavoriteBooks().addToFavourites("title");
        System.out.println(new FavoriteBooks().getFavouritesFromFile());
        new FavoriteBooks().removeFromFavourites("lineContent");
        System.out.println(new FavoriteBooks().getFavouritesFromFile());
    }
}
