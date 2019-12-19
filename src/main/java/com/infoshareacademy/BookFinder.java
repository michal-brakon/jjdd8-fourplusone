package com.infoshareacademy;

import com.infoshareacademy.Language.LangKeyConfig;
import com.infoshareacademy.Language.Language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BookFinder {

    Language l = new Language();
   private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

   private static final  List<Book> BOOKS = BookRepository.getInstance().getBooks();

   private static final int SEARCH_BY_AUTHOR = 1;
   private static final int SEARCH_BY_TITLE = 2;
   private static final int SEARCH_BY_AUTHOR_AND_TITLE = 3;
   private static final int HAS_AUDIO = 1;
   private static final int HAS_NOT_AUDIO = 2;



    public void runBookFinder(int param, int hasAudio) {

        String author = "";
        String title = "";

        if (param == SEARCH_BY_AUTHOR) {

            stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.SEARCHING_FOR_BOOKS_BY_AUTHOR));

            List<String> authorsList;
            while (author.isEmpty()) {
                authorsList = findAuthorByName(getLetters());
                author = verifyFindingAuthor(authorsList);
            }

            findBooks(param, hasAudio, author, "");
        }
        if (param == SEARCH_BY_TITLE) {

            stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.SEARCHING_BOOKS_TITLE));

            List<String> titleslist;
            while (title.isEmpty()) {
                titleslist = findTitleByName(getLetters());
                title = verifyFindingAuthor(titleslist);
            }
            findBooks(param, hasAudio, "", title);
        }
        if (param == SEARCH_BY_AUTHOR_AND_TITLE) {

            stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.SEARCH_BY_BOOK_AND_AUTHOR));

            List<String> authorsList;
            while (author.isEmpty()) {
                authorsList = findAuthorByName(getLetters());
                author = verifyFindingAuthor(authorsList);
            }

            stdout.info("\n",l.getMessageByKey(LangKeyConfig.NOW_TITLE));

            List<String> titleslist;
            while (title.isEmpty()) {
                titleslist = findTitleByName(getLetters());
                title = verifyFindingTitle(titleslist);
            }
            findBooks(param, hasAudio, author, title);
        }
    }
    private String getLetters() {

        Scanner scanner = new Scanner(System.in);
        String letters = "";
        while ((letters.length() < 3) && (!letters.contains(" "))) {


            stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.ENTER_AT_LEAST_3_CHAR));

            letters = scanner.next();
        }
        return letters;
    }

    private List<String> findAuthorByName(String letters) {

        List<String> authorsList = BOOKS.stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().toLowerCase().contains(letters.toLowerCase()))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        return authorsList;
    }

    private String verifyFindingAuthor(List<String> authorsList) {

        if (authorsList.isEmpty()) {

            stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.NO_MACHING_RES));        } else if (authorsList.size() > 1) {
            stdout.info("\n{}\n" , authorsList.size());
            printList(authorsList);
            stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.REFINE_YOUR_SELECTION));

            authorsList.removeAll(authorsList);
        } else {
            stdout.info("\nCzy chodziło ci o {}  ?  (t - tak) \n", authorsList.get(0));
            Scanner scanner = new Scanner(System.in);
            String confirmationType = scanner.next();
            if (!confirmationType.equalsIgnoreCase("t")) {

                stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.TRY_AGAIN));

            } else {
                return authorsList.get(0);
            }
        }

        return "";
    }

    private List<String> findTitleByName(String letters) {

        return BOOKS.stream()

                .filter(b -> b.getTitle() != null)
                .filter(b -> b.getTitle().toLowerCase().contains(letters.toLowerCase()))
                .map(Book::getTitle)
                .distinct()
                .collect(Collectors.toList());

    }

    private String verifyFindingTitle(List<String> titlesList) {

        String title = "";

        if (titlesList.isEmpty()) {
            stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.NO_MACHING_RES));            findTitleByName(getLetters());

        } else if (titlesList.size() > 1) {
            stdout.info("\nZnaleziono {} pasujących autorów: \n", titlesList.size());
            printList(titlesList);
            stdout.info("\nUściślij swój wybór\n ");
            findTitleByName(getLetters());
        } else {
            stdout.info("\nCzy chodziło ci o {}  ?  (t - tak) \n", titlesList.get(0));
            Scanner scanner = new Scanner(System.in);
            String confirmationType = scanner.next();
            if (!confirmationType.equalsIgnoreCase("t")) {

                stdout.info("\n{}\n", l.getMessageByKey(LangKeyConfig.TRY_AGAIN));

            } else {
                return titlesList.get(0);
            }
        }
        return title;
    }

    private void printList(List<String> list) {
        int counter = 1;
        for (String element : list) {
            stdout.info("{}. {}", counter, element);
            counter++;

        }

    }

    private void findBooks(int searchingMethod, int hasAudio, String author, String title) {

        List<Book> filteredBooks = BOOKS;

        if (hasAudio == HAS_AUDIO) {
            filteredBooks = filteredBooks.stream()

                    .filter(Book::isHasAudio)

                    .collect(Collectors.toList());
        }
        if (hasAudio == HAS_NOT_AUDIO) {
            filteredBooks = filteredBooks.stream()
                    .filter(b -> !b.isHasAudio())
                    .collect(Collectors.toList());
        }

        if (searchingMethod == SEARCH_BY_AUTHOR) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());

        } else if (searchingMethod == SEARCH_BY_TITLE) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .collect(Collectors.toList());


        } else if (searchingMethod == SEARCH_BY_AUTHOR_AND_TITLE) {
            filteredBooks = filteredBooks.stream()
                    .filter(Objects::nonNull)
                    .filter(b -> b.getTitle().equals(title))
                    .filter(b -> b.getAuthor().equals(author))
                    .collect(Collectors.toList());
        }

        printBooks(filteredBooks);
    }

    private void printBooks (List<Book> books)  {

        if (books.isEmpty()) {
            stdout.info("\n",l.getMessageByKey(LangKeyConfig.THERE_ARE_NO_BOOKS));

        }  else {
            books.forEach(x -> stdout.info(String.valueOf(x)));
        }
    }
}


