package com.infoshareacademy;

import java.io.IOException;

public class ClearScreen {
    static void clearScreen() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
