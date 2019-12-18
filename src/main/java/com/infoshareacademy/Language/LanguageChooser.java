package com.infoshareacademy.Language;

import java.util.*;

public class LanguageChooser {

            return Arrays.asList(LangKeyConfig.values()).forEach(key -> {
            LanguageMessagesHolder.getMessages().put(key.getValue(), messagesBundle.getString(key.getValue()));
        });
    }


    private Locale locale = new Locale("pl");
     ResourceBundle messagesBundle = ResourceBundle.getBundle("messages", locale);

    public String getMessageByKey(LangKeyConfig langKeyConfig) {
        return LanguageMessagesHolder.getMessages().get(langKeyConfig.getValue());

    }

}
