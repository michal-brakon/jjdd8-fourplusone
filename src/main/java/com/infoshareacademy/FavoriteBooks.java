package com.infoshareacademy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FavoriteBooks {

    //private static List<Book> BOOKS = BookRepository.getInstance().getBooks();

    public List<String> getFavouritesFromFile() throws FileNotFoundException {
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

//    public static void main(String[] args) throws IOException {
//        new FavoriteBooks().addToFavourites("title");
//        System.out.println(new FavoriteBooks().getFavouritesFromFile());
//    }
}
