package com.infoshareacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ClearScreen {
    static void clearScreen() {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("clear");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                System.out.println("CHARS: " + getChars(s));
                System.out.println(s);
            }
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
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
