package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class FavouritesManager {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public List<String> getFavouritesFromFile() throws IOException {

        File file = new File("favourites.txt");
        List<String> favouriteTitles = Files.lines(file.toPath())
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());

        return favouriteTitles;
    }
    public void addToFavourites (String title) throws IOException {

        if (getFavouritesFromFile().size() < 3 && !getFavouritesFromFile().contains(title)) {
            FileWriter file = new FileWriter("favourites.txt", true);
            BufferedWriter out = new BufferedWriter(file);
            out.write("\n" + title);
            out.close();
        }
        else if (getFavouritesFromFile().size() < 3) {
            stdout.info("\nLista ulubionych jest pelna \n");
        }
        else  if (getFavouritesFromFile().contains(title)) {
            stdout.info("\nPozycja jest juz w ulubionych \n");
        }
    }
    
    public void removeFromFavourites (String title) throws IOException {

        File file = new File("favourites.txt");
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(title))
                .collect(Collectors.toList());

        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        stdout.info("\nUsunieto: {}", title);
    }
}
