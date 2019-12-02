package com.infoshareacademy;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    //int choices = 0;
    Scanner scan = new Scanner(System.in);

    public int getChoice(int choices) {

        System.out.println("Type your choice: ");
        String Choice = scan.nextLine();
        int choice = 0;

        try {
            choice = Integer.parseInt(Choice);
        } catch (NumberFormatException e) {
            System.out.println("You typed a letter! ");
            getChoice(choices);
        }
        if (choice>choices && choice<0)  {
            System.out.println("Please choice correct number! ");
            getChoice(choices);
        }

        return choice;
    }

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.mainMenu();
    }

    public void mainMenu()  {

        System.out.println("1. wypozycz");
        System.out.println("2. oddaj");
        System.out.println("3. lista ksiazek");
        System.out.println("-----");
        System.out.println("0. wyjscie");

        switch (getChoice(3))  {

            case 1: wypozyczMenu();
            case 2: oddajMenu();
            case 3: listaKsiazekMenu();
            case 4: mainMenu();
            case 0: exit();
        }

    }

    public void exit() {
        System.out.println("Dozobaczenia!");
        return;
    }

    private void listaKsiazekMenu() {
        System.out.println("1. sortuj po autorze");
        System.out.println("2. sortuj po gatunku");
        System.out.println("3. sortuj po tytule");
        System.out.println("4. main menu");
        System.out.println("0. wyjscie");

        switch (getChoice(4)) {
            case 1: {}
            case 2: {}
            case 3: {}
            case 4: mainMenu();
            case 0: exit();
        }

    }
    private void mojeKontoMenu() {

    }
    private void oddajMenu()  {

    }
    private void wypozyczMenu()  {

    }

}
