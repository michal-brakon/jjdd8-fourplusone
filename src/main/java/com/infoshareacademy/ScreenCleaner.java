package com.infoshareacademy;

import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ScreenCleaner {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private ScreenCleaner() {
    }

   public static void clearScreen() {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("clear");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
               stdout.info("CHARS: {}", getChars(s));
                stdout.info(s);
            }
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            Language l = new Language();
            stdout.info("\n", l.getMessageByKey(LangKeyConfig.RETURN_TO_PREVIOUS_MENU));
        }
    }

    private static List<Byte> getChars(String s) {
        List<Byte> list = new ArrayList<>();
        for (char a : s.toCharArray()) {
            list.add((byte) a);
        }
        return list;
    }

}
