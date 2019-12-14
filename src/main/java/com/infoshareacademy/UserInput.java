package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInput {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


    private int choice = 0;
    private Scanner scan = new Scanner(System.in);


    public int getChoice(int choices) {

        String userLineIn = scan.nextLine();
        if (isANumber(userLineIn)) {


            choice = Integer.parseInt(userLineIn);

        } else {
            wrongChoiceChooseAgain(choices);
        }
        if (choice > choices || choice < 0) {
           wrongNumberChooseAgain(choices);
        }

        return choice;
    }

    public boolean isANumber(String userLineIn) {
        return (Pattern.matches(("[0-9]"), userLineIn) || (Pattern.matches("[0-9][0-9]", userLineIn))) && userLineIn != null;
    }

    private void wrongChoiceChooseAgain(int choices) {
        stdout.info("Źle wpisałeś! \nSprobuj ponownie:\n");
        getChoice(choices);
    }
    private void wrongNumberChooseAgain(int choices) {
        stdout.info("\nProsze wybrać jeden z " + choices + "\n");
        getChoice(choices);
    }
}
