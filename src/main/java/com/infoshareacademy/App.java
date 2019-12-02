package com.infoshareacademy;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        stdout.info("Hello World!");
      //  ObjectMapper objectMapper=new ObjectMapper();

//        InputStream is = App.class.getClassLoader().getResourceAsStream("baza.json");

      //  try {
//            String s = new String(is.readAllBytes(), StandardCharsets.UTF_8);
//            System.out.println(s);
//
//       //     List booksList = (List) objectMapper.readValue(new File("baza.json"), Books.class );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }







    }





}