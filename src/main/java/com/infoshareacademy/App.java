package com.infoshareacademy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        stdout.info("Hello World!");

        InputStream is = App.class.getClassLoader().getResourceAsStream("abc.json");


        try {
            String s = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }



       // Books[] books = objectMapper.readValue(s, Books[]);




    }





}