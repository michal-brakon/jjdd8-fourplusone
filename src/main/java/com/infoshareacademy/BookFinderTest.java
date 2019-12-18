package com.infoshareacademy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BookFinderTest {

    @Test
    @DisplayName("Return list of matching author's name")
    public void should_find_authors_matching_given_letters ()  {

        String letters = "kra";

        List<String> authorsList = BookRepository.getInstance().getBooks().stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().toLowerCase().contains(letters.toLowerCase()))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        assertEquals(2, authorsList.size());
    }
}