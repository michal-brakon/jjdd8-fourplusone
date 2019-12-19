package com.infoshareacademy.Language;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    Locale locale = new Locale("eng");


    ResourceBundle messagesBundle = ResourceBundle.getBundle("messages_pl", locale);

    public String getMessageByKey(LangKeyConfig langKeyConfig) {

        Arrays.asList(LangKeyConfig.values()).forEach(key -> {
            LanguageMessagesHolder.getMessages().put(key.getValue(), messagesBundle.getString(key.getValue()));
        });

        return LanguageMessagesHolder.getMessages().get(langKeyConfig.getValue());
    }

    public void setMessagesBundle(ResourceBundle messagesBundle) {
        this.messagesBundle = messagesBundle;
    }

}
