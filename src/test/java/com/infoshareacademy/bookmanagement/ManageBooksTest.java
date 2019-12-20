package com.infoshareacademy.bookmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ManageBooksTest {

    private ManageBooks manageBooks;

    @BeforeEach
    void setUp() {
        manageBooks = new ManageBooks();

    }

    @Test
    void findBookById() {

        Long id = 0L;
        assertNull(manageBooks.findBookById(id));

    }

    @Test
    void getSequenceid() {
        assertNotNull(manageBooks.getSequenceId());
    }

}
