package com.infoshareacademy.Language;

import java.util.HashMap;
import java.util.Map;

public class LanguageMessagesHolder {

    private static Map<String, String> messages = new HashMap<>();

    public static Map<String, String> getMessages() {
        return messages;
    }
}
