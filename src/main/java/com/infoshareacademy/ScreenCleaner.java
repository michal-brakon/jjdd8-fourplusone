package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ScreenCleaner {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    static void clearScreen() {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("clear");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
               stdout.info("CHARS: " + getChars(s));
                stdout.info(s);
            }
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            stdout.info("\nCzyszczenie ekranu zakonczylo sie niepowodzeniem");
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
