package com.infoshareacademy;
import javax.xml.xpath.XPath;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {


//    String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "config.properties";
//
//    AppProperties prop = new AppProperties();
//    prop.load(new FileInputStream inputStream).;
//
//


    @Override
    public String toString() {
        return "AppProperties{" +
                "result='" + result + '\'' +
                ", inputStream=" + inputStream +
                '}';
    }

    private void load(InputStream inputStream) {
    }

    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String nazwaPliku = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(nazwaPliku);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Plik " + nazwaPliku + " nie znaleziony");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        AppProperties n = new AppProperties();
        System.out.println(n.getPropValues());


    }
}
//
//
////
////
////    String configPath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "config.properties";
////
////
////    Properties prop = new Properties();
////        prop.load(new FileInputStream(configPath));
////
////
////
//
//
