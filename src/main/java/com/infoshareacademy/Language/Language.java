package com.infoshareacademy.Language;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Language {

    private static Locale locale = new Locale("eng");
    private static ResourceBundle messagesBundle = ResourceBundle.getBundle("messages", locale);

    public static String getMessageByKey(LangKeyConfig langKeyConfig) {

        Arrays.asList(LangKeyConfig.values()).forEach(key -> {
            LanguageMessagesHolder.getMessages().put(key.getValue(), messagesBundle.getString(key.getValue()));
        });

        return LanguageMessagesHolder.getMessages().get(langKeyConfig.getValue());
    }
}
