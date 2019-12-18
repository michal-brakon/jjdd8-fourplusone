package com.infoshareacademy.Language;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    String baseName;


    public Language(String baseName) {

        this.baseName = baseName;
    }

    Locale locale = new Locale("eng");
    public ResourceBundle messagesBundle = ResourceBundle.getBundle(baseName, locale);


    public String getMessageByKey(LangKeyConfig langKeyConfig) {

        Arrays.asList(LangKeyConfig.values()).forEach(key -> {
            LanguageMessagesHolder.getMessages().put(key.getValue(), messagesBundle.getString(key.getValue()));
        });

        return LanguageMessagesHolder.getMessages().get(langKeyConfig.getValue());
    }
}
