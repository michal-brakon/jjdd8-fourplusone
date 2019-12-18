package com.infoshareacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FavouritesManager {

    private static List<Book> BOOKS = new BookRepository().getInstance().getBookRepository();

    public void addFavourites (String title) throws FileNotFoundException {

        List<String> lines = new ArrayList<>();
        File file = new File("favourites.txt");
        if (!isFileExist(file))  {
            System.out.println("Blad odczytu pliku");
            return;
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())  {
            lines.add(scanner.nextLine());
        }
        if (lines.contains(title)) {
            System.out.println("Pozycja jest juz w ulubionych");
            return;
        }
        if (lines.size() <= 2 && !lines.contains(title)) {

            PrintWriter printWriter = new PrintWriter("favourites.txt");
            printWriter.println(title);
            printWriter.close();
        }   else if (lines.contains(title))  {
            System.out.println("Pozycja jest juz w ulubionych");
            return;
        }   else  {
            System.out.println("Lista ulubionych pelna");
        }

    }

    private void printFavourites() throws FileNotFoundException {
        File file = new File("favourites.txt");
        if (!isFileExist(file))  {
            System.out.println("Blad odczytu pliku");
            return;
        }
        Scanner scanner = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine())  {
            lines.add(scanner.nextLine());
        }


    }

    private boolean isFileExist(File f) {

        return f.exists() && f.isFile();
    }

}







