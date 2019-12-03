package com.infoshareacademy;

import com.sun.jdi.Value;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookList {

    Menu menu = new Menu();
    private int record = 1;
    private int recordsLimit = 0;
    ArrayList list = new ArrayList<Book>();


    public static void main(String[] args) {

       // BookList bookList = new BookList();

    }

    public void printBooks(ArrayList<Book> books) {
        Menu menu = new Menu();

        while (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) {
            System.out.println("How many records on page? (5,10,15) ");
            recordsLimit = menu.getChoice(15);
            if (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) System.out.println("Wrong number!");
        }

        for (Book book : books) {
            System.out.println(record+". "+book);
            list.add(book);
            int i;
            if (record > recordsLimit || record >= books.size()) {

                System.out.println("Type your choice: ");
                System.out.println("number of book to print a book");
                if (!(record >= books.size())) {
                    System.out.println("any key - next page");
                }
                System.out.println("m - main menu");
                System.out.println("q - close application");

                Scanner scanner = new Scanner (System.in);
                String choice1 = scanner.next();

                try {
                    i = Integer.valueOf(choice1);
                    printBook(i);
                }  catch (NumberFormatException e)  {
                        ClearScreen.clearScreen();
                        switch (choice1) {
                            case "q": {
                                menu.exit();
                                break;
                            }
                            case "m": {
                                menu.mainMenu();
                                break;
                            }
                        }
                    }


                }

            }
        }


    private void printBook(int choice) {
        System.out.println(list.get(choice));

        }

}
