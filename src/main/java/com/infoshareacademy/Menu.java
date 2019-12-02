package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;


public class Menu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private int choice = 0;
    private Scanner scan = new Scanner(System.in);

    private int getChoice(int choices) {

        stdout.info("\nGdzie chcesz się udać: ");
        String Choice = scan.nextLine();
        //int choice = 0;

        try {
            choice = Integer.parseInt(Choice);
        } catch (NumberFormatException e) {
            stdout.info("\nWpisałeś litere! ");
            getChoice(choices);
        }
        if (choice>choices || choice<0)  {
            stdout.info("\nProsze wybrać jeden z "+choices+" wyborów");
            getChoice(choices);
        }

        return choice;
    }

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.mainMenu();
    }

    private void mainMenu()  {

        stdout.info("\n1. wypozycz");
        stdout.info("\n2. oddaj");
        stdout.info("\n3. lista ksiazek");
        stdout.info("\n-----");
        stdout.info("\n0. wyjscie");

        switch (getChoice(3))  {

            case 1: {
                wypozyczMenu();
                break;
            }
            case 2: {
                oddajMenu();
                break;
            }
            case 3:  {
                listaKsiazekMenu();
                break;
            }

            case 0: exit();
        }

    }

    private void exit() {
        ClearScreen.clearScreen();
        stdout.info("\nDo zobaczenia!");
    }

    private void listaKsiazekMenu() {
        ClearScreen.clearScreen();
        stdout.info("\n1. sortuj po autorze");
        stdout.info("\n2. sortuj po gatunku");
        stdout.info("\n3. sortuj po tytule");
        stdout.info("\n4. główne menu");
        stdout.info("\n0. wyjscie");

        switch (getChoice(4)) {
            case 1: {}
            case 2: {}
            case 3: {}
            case 4: {
                mainMenu();
                break;
            }
            case 0: exit();
        }

    }

    private void oddajMenu()  {

    }
    private void wypozyczMenu()  {

    }

}