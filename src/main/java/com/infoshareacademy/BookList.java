package com.infoshareacademy;

import java.util.ArrayList;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookList {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    ArrayList<Book> myList = new ArrayList<>();
    private int record;
    private int recordsLimit = 0;
    int counter;
    Menu menu = new Menu();
    public static void main(String[] args) {

//        BookList bookList = new BookList();
//        //ArrayList<Book> myList = new ArrayList<Book>();
//
//        myList.add(new Book("dhahasds", "ysud", "tytul1", "sd", "dsas", "sas", "asd", false, "das"));
//        myList.add(new Book("dsdfdssds", "ysud", "tytul2", "sd", "dsas", "sas", "asd", false, "das"));
//        myList.add(new Book("dhahasds", "ysud", "tytul3", "sd", "dsas", "sas", "asd", false, "das"));
//        myList.add(new Book("dhahasds", "ysvxcd", "tytul4", "sd", "dsas", "sas", "asd", false, "das"));
//        myList.add(new Book("dhahasds", "ysud", "tytul5", "sd", "dsas", "sas", "asd", false, "das"));
//        myList.add(new Book("dhahasds", "ysud", "tytul6", "sd", "dsas", "sas", "asd", false, "das"));
//        myList.add(new Book("dhahasds", "ysud", "tytul7", "sd", "dsas", "sas", "asd", false, "das"));
//        myList.add(new Book("dhahasds", "ysud", "tytul8", "sd", "dsas", "sas", "asd", false, "das"));
//
//        bookList.printBooks(myList);

    }

    public void printBooks(ArrayList<Book> books) {

        record = 1;
        counter = 1;
        recordsLimit = 0;

        while (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) {
            System.out.println("How many records on page? (5,10,15) ");
            recordsLimit = menu.getChoice(15);
            if (recordsLimit != 5 && recordsLimit != 10 && recordsLimit != 15) System.out.println("Wrong number!");
        }

        for (Book book : books) {

            if (record < books.size()+1)  System.out.println(record+ ". " + book);
            counter++;
            record++;

            if (counter > recordsLimit ) {
                System.out.println("Type q to finish list, any to continue book list");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("q")) { record = books.size()+1;  }
                counter = 1;
            }
        }

    menuBookList();

    }
    private void menuBookList ()  {

        counter = 1;
        System.out.println("Type your choice: ");
        System.out.println("c -       choose book");
        System.out.println("m -       main menu");
        System.out.println("q -       close application");

        Scanner scanner = new Scanner(System.in);
        String choice1 = scanner.next();

        switch (choice1) {
            case "q": {
                menu.exit();
                break;
            }
            case "m": {
                menu.mainMenu();
                break;
            }
            case "c": {
                System.out.println(myList.get(chooseBookToPrint()));
                break;
            }
        }

        return;
    }
    private int chooseBookToPrint () {
        System.out.println("Wpisz numer ksiazki: ");
        Scanner scanner = new Scanner(System.in);
        int bookChoice = 0;
        try {
            bookChoice = scanner.nextInt() -1 ;
        } catch (NumberFormatException e)  {
            System.out.println("Type a number of book!");
            chooseBookToPrint();
        }

        return bookChoice;

    }

}


