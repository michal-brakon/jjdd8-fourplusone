package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import java.util.List;


public class NewMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();


    public void newMenu(int position) {
        MenuOptions menu1 = new MenuOptions("glowne menu",1, 0);
        MenuOptions menu2 = new MenuOptions("zwróć książke",2, 1);
        MenuOptions menu3 = new MenuOptions("wypożycz książke",3, 1);
        MenuOptions menu4 = new MenuOptions("dostępne książki",4, 1);
        MenuOptions menu5 = new MenuOptions("lista książek",41, 4);
        MenuOptions menu6 = new MenuOptions("glowne menu",42, 4);
        List<MenuOptions> newMenuList = new ArrayList<>();
        newMenuList.add(menu1);
        newMenuList.add(menu2);
        newMenuList.add(menu3);
        newMenuList.add(menu4);
        newMenuList.add(menu5);
        newMenuList.add(menu6);
        while (position != 0) {
            if (position == 1) {
                stdout.info("\033[H\033[2J");
                stdout.info("Witamy na Glownej stronie biblioteki For Plus One");

            }




            int parent= 0;
            for (MenuOptions menuOptions : newMenuList) {
                if (menuOptions.getPosition() == position) {
                    parent = menuOptions.getParent();
                }

            }
            int[] choicesNumber = new int[10];
            int pressNumber = 1;
            for (MenuOptions menuOptions : newMenuList) {

                if (menuOptions.getParent() == position) {

                    stdout.info("\n" + pressNumber + " " + menuOptions.getDisplayedText());

                    choicesNumber[pressNumber] = menuOptions.getPosition();
                    pressNumber++;
                }

            }
            stdout.info("\n0 wróć do poprzedniego menu");
            int userChoice = getNumber.getChoice(pressNumber);
            if (userChoice!=0) {
                position = choicesNumber[pressNumber-1];

            } else {
                position = parent;

            }



        }

    }

}
