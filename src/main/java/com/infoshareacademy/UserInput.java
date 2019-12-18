package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Pattern;

import static com.infoshareacademy.Menu.EXIT_POSITION;

public class UserInput {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


    private int choice = EXIT_POSITION;
    private Scanner scan = new Scanner(System.in);


    public int getChoice(int choices) {

        String userLineIn = scan.nextLine();
        if (isANumber(userLineIn)) {


            choice = Integer.parseInt(userLineIn);

        } else {
            isNotANumber(choices);
        }
        if (choice > choices || choice < 0) {
            incorrectNumberRetry(choices);
        }

        return choice;
    }

    public boolean isANumber(String userLineIn) {
        return (Pattern.matches(("[0-9]"), userLineIn) || (Pattern.matches("[0-9][0-9]", userLineIn))) && userLineIn != null;
    }

    private void isNotANumber(int choices) {
        stdout.info("Źle wpisałeś! \nSpróbuj ponownie:\n");
        getChoice(choices);
    }

    private void incorrectNumberRetry(int choices) {
        stdout.info("\nProszę wybrać jeden z {} \n", choices);
        getChoice(choices);
    }
}
