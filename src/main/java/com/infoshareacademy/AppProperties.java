package com.infoshareacademy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
    Properties properties = new Properties();

    public String getProp() {
        try {
            File file = new File("config.properties");
            FileInputStream fileInput = new FileInputStream(file);
            properties.load(fileInput);
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty("sortByTitle");
    }

    public static void main(String[] args) {
        AppProperties n = new AppProperties();
        System.out.println(n.getProp());
    }
}
