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
        if (Pattern.matches(("[0-9]"), userLineIn) || Pattern.matches(("[0-9][0-9]"), userLineIn)) {
            try {
                choice = Integer.parseInt(userLineIn);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            stdout.info("Źle wpisałeś!");
            getChoice(choices);
        }
        if (choice > choices || choice < 0) {
            stdout.info("\nProsze wybrać jeden z " + choices);
            getChoice(choices);
        }

        return choice;
}}
