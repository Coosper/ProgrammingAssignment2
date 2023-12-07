package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FictionBookTest {

    private FictionBook fictionBook;

    @BeforeEach
    void setUp() {
        fictionBook = new FictionBook("1984", "George Orwell", "978-0451524935", 328, 1949, "Dystopian");
    }

    @Test
    void getGenre() {
        assertEquals("Dystopian", fictionBook.getGenre());
    }

    @Test
    void setGenre() {
        fictionBook.setGenre("Science Fiction");
        assertEquals("Science Fiction", fictionBook.getGenre());
    }

    @Test
    void testToString() {
        String expected = "Fiction Book - ISBN: 978-0451524935, Title: 1984, Author: George Orwell, No. of Pages: 328, Year Published: 1949, Genre: Dystopian";
        assertEquals(expected, fictionBook.toString());
    }

    @Test
    void testGetEdition() {
        String expectedEdition = "This is the latest edition of this book.";
        assertEquals(expectedEdition, fictionBook.getEdition());
    }
}