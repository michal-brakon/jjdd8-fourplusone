package com.infoshareacademy;

import com.sun.jdi.Value;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookList implements KeyListener {

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
            System.out.println("1. "+book);
            list.add(book);
            if (record > recordsLimit || record >= books.size()) {
                //TODO: oczekiwanie na akcje uzytkownika:
                Scanner scanner = new Scanner (System.in);
                String choice1 = scanner.next();
                ArrayList<String> letters = new ArrayList<String>();
                letters.add("q");
                letters.add("m");
                System.out.println("Type your choice: ");
                System.out.println("number of book to print a book");
                if (!(record >=books.size())) {
                    System.out.println("n - next page");
                    letters.add("n");
                }
                System.out.println("m - main menu");
                System.out.println("q - close application");

                try {
                    int i = Integer.valueOf(choice1);
                }  catch (NumberFormatException e)  {
                    if (letters.contains(choice1)) {
                        ClearScreen.clearScreen();
                        switch (choice1) {
                            case "q": {
                                menu.exit();
                                break;
                            }
                            case "m": {
                                menu.mainMenu();
                                break;
                                //TODO: case 'n'
                            }

                        }
                    }
                }


                ClearScreen.clearScreen();


            }
        }
    }

    private void printBook(int choice) {
        System.out.println(list.get(choice));

        }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
