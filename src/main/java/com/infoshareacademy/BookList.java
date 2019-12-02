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
            System.out.println(book);
            list.add(book);
            if (record > recordsLimit) {

                //oczkiwanie na akcje uzytkownika:


                ClearScreen.clearScreen();

                //record = 1;
            }
        }
    }

    private void printBook(HashMap mapa) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Type your choice: ");
        int choice = scanner.nextInt();

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
