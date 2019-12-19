package com.infoshareacademy;

import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Pattern;

import static com.infoshareacademy.Menu.CHANGE_LANGUAGE_OPTION;
import static com.infoshareacademy.Menu.EXIT_POSITION;

public class UserInput {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    Language l = new Language();
    private int choice = EXIT_POSITION;
    private Scanner scan = new Scanner(System.in);


    public int getChoice(int choices) {

        String userLineIn = scan.nextLine();
        if (checkIsStringANumber(userLineIn)) {


            choice = Integer.parseInt(userLineIn);

        } else if (checkIfStringAChangeLanguageButton(userLineIn)) {
            return CHANGE_LANGUAGE_OPTION;
        } else {
            isNotANumber(choices);
        }
        if (choice > choices || choice < 0) {
            incorrectNumberRetry(choices);
        }

        return choice;
    }

    public boolean checkIsStringANumber(String userLineIn) {
        return (Pattern.matches(("[0-9]"), userLineIn) || (Pattern.matches("[0-9][0-9]", userLineIn))) && userLineIn != null;
    }

    public boolean checkIfStringAChangeLanguageButton(String userLineIn) {
        return (Pattern.matches("l", userLineIn));

    }

    private void isNotANumber(int choices) {
        stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.WRONG_INPUT_TRY_AGAIN));
        getChoice(choices);
    }

    private void incorrectNumberRetry(int choices) {
        stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.PLEASE_CHOOSE_ONE_OF), choices);
        getChoice(choices);
    }
}
