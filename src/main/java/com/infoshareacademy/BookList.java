package com.infoshareacademy;

import java.util.ArrayList;
import com.infoshareacademy.Menu;

public class BookList {

    ArrayList<Books> books = new ArrayList<Books>();
    private int record = 0;
    private int recordsLimit = 0;

    public static void main(String[] args) {

        BookList bookList = new BookList();
        //bookList.printBooks();
    }
    public void printBooks(ArrayList<Books> books) {
        Menu menu = new Menu();

        while (recordsLimit != 5 && recordsLimit !=10 && recordsLimit !=15) {
            System.out.println("How many records on page? (5,10,15) ");
            recordsLimit = menu.getChoice(15);
            if (recordsLimit != 5 && recordsLimit !=10 && recordsLimit !=15) System.out.println("Wrong number!");
        }
        for (Books book : books)  {
            System.out.println("Title: " + book.title + "Author: " + book.author + "Genre: " + book.genre);
            record++;
            if (record > recordsLimit)  {
                ClearScreen.clearScreen();
                record = 0;
            }
        }
    }
}
