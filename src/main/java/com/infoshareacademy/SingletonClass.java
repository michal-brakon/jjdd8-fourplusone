package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class SingletonClass {

    private static List<ExternalBook> newlist = ExternalBook.externalBooks;

    public SingletonClass() {
    }

    public List getExternalBooks() {
        if (newlist == null) {
            System.out.println("Baza jest pusta");
        }
        return newlist;
    }
}