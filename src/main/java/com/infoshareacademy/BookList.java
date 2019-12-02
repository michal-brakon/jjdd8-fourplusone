package com.infoshareacademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookList {

    ArrayList<Book> books = new ArrayList<Book>();
    private int record = 0;
    private int recordsLimit = 0;
    Map mapa = new HashMap<String, Integer>();


    public static void main(String[] args) {

        BookList bookList = new BookList();
        //bookList.printBooks();
    }

    public void printBooks(ArrayList<Book> books) {
        Menu menu = new Menu();

        while (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) {
            System.out.println("How many records on page? (5,10,15) ");
            recordsLimit = menu.getChoice(15);
            if (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) System.out.println("Wrong number!");
        }

        for (Book books1 : books) {
            System.out.println("Title: " + books1.title + "Author: " + books1.author + "Genre: " + books1.genre);
            mapa.put(books1.title, record);
            if (record > recordsLimit) {
                ClearScreen.clearScreen();
                record = 0;
            }
        }
    }

    private void printBook(HashMap mapa) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Type your choice: ");
        int choice = scanner.nextInt();

        for (Book books2 : books) {
            if (Map)

            System.out.println();
        }
    }
}
