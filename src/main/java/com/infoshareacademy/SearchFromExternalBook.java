package com.infoshareacademy;

import java.util.Scanner;

public class SearchFromExternalBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new BookParser();
        System.out.println("podaj rodzaj ksiażki: ");
        String searchOfKind = scanner.nextLine();
        for (int i = 0; i < ExternalBook.externalBooks.size(); i++) {

            ExternalBook record = ExternalBook.externalBooks.get(i);
            if (record.getAuthor().contains(searchOfKind))
                System.out.println(record.getKind() + "\n" + record.getUrl() + "\n" + record.getAuthor());

        }
    }
}