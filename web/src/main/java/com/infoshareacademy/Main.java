package com.infoshareacademy;

import com.infoshareacademy.domain.api.Book;
import com.infoshareacademy.service.BookApiConsumer;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        try {
            List<Book> bookList = new BookApiConsumer().consumeBooks();
            for (Book book : bookList) {
                System.out.println(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        }


    }

