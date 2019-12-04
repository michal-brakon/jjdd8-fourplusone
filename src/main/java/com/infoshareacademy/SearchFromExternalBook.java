package com.infoshareacademy;

import java.util.List;
import java.util.Scanner;

public class SearchFromExternalBook {
    public static void main(String[] args) {
        new BookParser();
        SingletonClass nowa = new SingletonClass();
        nowa.getExternalBooks();

        System.out.println(nowa.getExternalBooks().size());

        }





//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.println("podaj rodzaj ksiażki: ");
//        String searchOfKind = scanner.nextLine();
//        for (int i = 0; i < ExternalBook.externalBooks.size(); i++) {
//
//            ExternalBook record = ExternalBook.externalBooks.get(i);
//            if (record.getAuthor().contains(searchOfKind))
//                System.out.println(record.getKind() + "\n" + record.getUrl() + "\n" + record.getAuthor());
//
//        }
//    }
}