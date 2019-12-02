package com.infoshareacademy;

import java.io.IOException;

public class ClearScreen {
    static void clearScreen()  {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
