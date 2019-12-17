package com.infoshareacademy;

import java.io.File;

public class FavouritesManager {

    public void addFavourites (Book book)  {

        String title = book.getTitle();
    }

    private boolean isFileExists (String filename) {

        File f = new File(filename);
        return f.exists() && f.isFile();
    }

    private boolean isNotTooManyFavourites () {

        File file = new File("favourites.txt");
    }


}
