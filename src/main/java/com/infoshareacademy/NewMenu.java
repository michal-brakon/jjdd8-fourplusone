package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NewMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();
    BookPrinter bookPrinter = new BookPrinter();


    public void newMenu(int position) {
        MenuOptions menu1 = new MenuOptions("glowne menu", 1, 0);
        MenuOptions menu2 = new MenuOptions("Przeglądaj zbiór książek", 2, 1);
        MenuOptions menu3 = new MenuOptions("Rezerwacja pozycji", 3, 1);
        MenuOptions menu4 = new MenuOptions("dostępne książki", 4, 1);
        MenuOptions menu8 = new MenuOptions("Ulubione", 5, 1);
        MenuOptions menu5 = new MenuOptions("Pokaż Wszystkie pozycje", 41, 4);
        MenuOptions menu6 = new MenuOptions("wyświetl jedną pozycje", 42, 4);
        MenuOptions menu7 = new MenuOptions("sortuj po tytule", 43, 4);
        MenuOptions menu9 = new MenuOptions("", 45, 3);
        MenuOptions menu10 = new MenuOptions("", 46, 44);
        List<MenuOptions> newMenuList = new ArrayList<>();
        newMenuList.add(menu1);
        newMenuList.add(menu2);
        newMenuList.add(menu3);
        newMenuList.add(menu4);
        newMenuList.add(menu5);
        newMenuList.add(menu6);
        newMenuList.add(menu7);
        newMenuList.add(menu8);
        newMenuList.add(menu9);
        newMenuList.add(menu10);


        while (position != 0) {
            stdout.info("\033[H\033[2J");
            stdout.info("\n");
            Header.headerPrinter();
            if (position == 1) {

                stdout.info("Witamy na Glownej stronie biblioteki For Plus One");


            } else if (position == 41) {
                new BookPrinter().printBooks(BookRepository.getBooks());
            } else if (position == 42) {                int n = new BookPrinter().chooseBookToPrint();
                stdout.info(n + 1 + ". " + BookRepository.getBooks().get(n));
                stdout.info("\n Nacisnij dowolny klawisz aby kontynuawać\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice != null)
                    continue;
            } else if (position == 43) {
                bookPrinter.chooseBookToPrint();
                new SearchBook().searchFromAuthor();
            }

            int parent = 0;
            for (int i=0; i<newMenuList.size();i++){
                if (newMenuList.get(i).getPosition()==position){
                    parent=newMenuList.get(i).getParent();
                }

            }
            int[] choicesNumber = new int[10];
            int pressNumber = 1;
            for (int i=0; i<newMenuList.size();i++){

                if (newMenuList.get(i).getParent() == position){

                    stdout.info("\n"+pressNumber+ " "+newMenuList.get(i).getDisplayedText());

                    choicesNumber[pressNumber]= newMenuList.get(i).getPosition();
                    pressNumber++;
                }

            }
            stdout.info("\n0 wróć do poprzedniego menu  ");
            int userChoice = getNumber.getChoice(pressNumber-1);
            stdout.info("\nwybrales "+userChoice);
            if (userChoice != 0) {
                position = choicesNumber[userChoice];

            } else if (userChoice == 0){
                position = parent;

            }


        }

    }

}
