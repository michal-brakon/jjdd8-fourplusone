package com.infoshareacademy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UserInput {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private int choice = 0;
    private Scanner scan = new Scanner(System.in);
    public int getChoice(int choices) {

        stdout.info("\nGdzie chcesz się udać: \n");
        String userLineIn = scan.nextLine();

        try {
            choice = Integer.parseInt(userLineIn);
        } catch (NumberFormatException e) {
            stdout.info("\nWpisałeś litere! ");
            getChoice(choices);
        }
        if (choice > choices || choice < 0) {
            stdout.info("\nProsze wybrać jeden z " + choices);
            getChoice(choices);
        }

        return choice;
}}
