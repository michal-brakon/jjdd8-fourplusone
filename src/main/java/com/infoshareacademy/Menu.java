package com.infoshareacademy;

import java.util.Scanner;

public class Menu {


    Scanner scan = new Scanner(System.in);
    //boolean isLogged = false;

    public int getChoice() {

        System.out.println("Wybierz: ");
        String Choice = scan.nextLine();
        int choice = Integer.valueOf(Choice);
        return choice;
    }



    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.mainMenu();
    }

    public void mainMenu()  {
        //Menu menu = new Menu();
        System.out.println("1. wypozycz");
        System.out.println("2. oddaj");
        System.out.println("3. lista ksiazek");
        System.out.println("4. moje konto");


        switch (getChoice())  {
            case 2: oddajMenu();
            case 3: listaKsiazekMenu();
            case 5: mainMenu();
        }

    }

    public void listaKsiazekMenu() {
        System.out.println("1. po autorze");
        System.out.println("5. main menu");

        switch (getChoice()) {
            case 5: mainMenu();
        }

    }
    public void mojeKontoMenu() {

    }
    public void oddajMenu()  {

    }

}
