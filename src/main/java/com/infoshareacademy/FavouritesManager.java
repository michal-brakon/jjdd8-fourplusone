package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;


public class FavouritesManager {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String FAVOURITES = "favourites.txt";
    private static final List<Book> BOOKS = BookRepository.getInstance().getBooks();


    public List<String> getFavouritesFromFile() throws IOException {

        File file = new File(FAVOURITES);
        return Files.lines(file.toPath())
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());
    }

    public void addToFavourites(String title) throws IOException {

        if (getFavouritesFromFile().size() < 3 && !getFavouritesFromFile().contains(title)) {
            FileWriter file = new FileWriter(FAVOURITES, true);
            BufferedWriter out = new BufferedWriter(file);
            out.write("\n" + title);
            out.close();
            updateBookList();
        } else if (getFavouritesFromFile().size() > 2) {
            stdout.info("\nLista ulubionych jest pelna \n");
        } else if (getFavouritesFromFile().contains(title)) {
            stdout.info("\n Pozycja {} jest juz w ulubionych \n",title);
        }
    }

    public void removeFromFavourites(String title) throws IOException {

        File file = new File(FAVOURITES);
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(title))
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());

        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        updateBookList();

        stdout.info("\nUsunieto: {} \n", title);
    }

    public void printFavBooks() throws IOException {

        List<String> favouritesTitles = getFavouritesFromFile();
        BOOKS.stream()
                .filter(b -> favouritesTitles.contains(b.getTitle()))
                .forEach(b -> stdout.info("\n{}", b));
    }

    private void updateBookList() throws IOException {
        List<String> favouritesTitles = getFavouritesFromFile();
        BOOKS.forEach(b -> b.favourite = favouritesTitles.contains(b.getTitle()) ? "tak" : "nie");

    }
}