package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.regex.Pattern;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private boolean isStringANumberInRange (int start, int end,String stringToTest) {
        int valueOfString = 0;
        if ((Pattern.matches(("[0-9][0-9]"), stringToTest)) || (Pattern.matches(("[0-9]"), stringToTest)))  {
            valueOfString = Integer.valueOf(stringToTest);
        }
        return valueOfString >= start && valueOfString <= end;
    }

    public static void main(String[] args) {

        // read json file to collection

        stdout.info("Four-Plus-One");

        // menu init

        Menu menu = new Menu();
        menu.mainMenu();



    }
}