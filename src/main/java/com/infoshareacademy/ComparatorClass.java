package com.infoshareacademy;

public class ComparatorClass implements java.util.Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getKind().compareTo(o2.getKind());
    }
}
