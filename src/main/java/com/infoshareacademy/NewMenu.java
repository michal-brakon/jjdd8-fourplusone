package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NewMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();
    public int position = 1;
    Stack<String> breadcrumbs = new Stack<>();



 /*   public void menuBreadcrumbs(int position) {
        String crumbs = " ";

        stdout.info("Menu główne<" + crumbs);
    }*/





    public void newMenu(int position) {
        MenuOptions menu1 = new MenuOptions("glowne menu",1, 0);
        MenuOptions menu2 = new MenuOptions("zwróć książke",2, 1);
        MenuOptions menu3 = new MenuOptions("wypożycz książke",3, 1);
        MenuOptions menu4 = new MenuOptions("dostępne książki",4, 1);
        MenuOptions menu5 = new MenuOptions("lista książek",41, 4);
        MenuOptions menu6 = new MenuOptions("glowne menu",42, 4);
        List<MenuOptions> newMenuList = new ArrayList();
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
              //  menuBreadcrumbs(position);
            } else if (position == 0) {
                stdout.info("\033[H\033[2J");
                stdout.info("zapraszamy ponownie");
                break;
            }




            int parent= 0;
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
            stdout.info("\n0 wróć do poprzedniego menu");
            int userChoice = getNumber.getChoice(pressNumber);
            if (userChoice!=0) {
                position = choicesNumber[pressNumber-1];

            } else if (userChoice == 0){
                position = parent;

            }



        }

    }

}
