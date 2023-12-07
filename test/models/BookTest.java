package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Test Title", "Test Author", "Test ISBN", 100);
    }
    @Test
    void getTitle() {
        assertEquals("Test Title", book.getTitle());
    }

    @Test
    void getAuthor() {
        assertEquals("Test Author", book.getAuthor());
    }

    @Test
    void getNumOfPages() {
        assertEquals(100, book.getNumOfPages());
    }

    @Test
    void getISBN() {
        assertEquals("Test ISBN", book.getISBN());
    }

    @Test
    void testToString() {
        String expected = "E-Book - ISBN: Test ISBN, Title: Test Title, Author: Test Author, No. of Pages: 100";
        assertEquals(expected, book.toString());
    }

    @Test
    void getBookType() {
        assertEquals("General", book.getBookType());
    }
}