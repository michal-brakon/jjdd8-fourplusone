package com.infoshareacademy;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Bdfsdf {  InputStream is = App.class.getClassLoader().getResourceAsStream("abc.json");


        try {
        String s = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(s);
    } catch (
    IOException e) {
        e.printStackTrace();
    }



    // Books[] books = objectMapper.readValue(s, Books[]);



}
