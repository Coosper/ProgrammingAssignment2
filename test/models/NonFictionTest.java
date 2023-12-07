package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonFictionTest {

    private NonFiction nonFictionBook;

    @BeforeEach
    void setUp() {
        nonFictionBook = new NonFiction("The Hidden Life of Trees", "Peter Wohlleben", "978-1455574112", 288, 2016, "Nature & Ecology");
    }

    @Test
    void getTopic() {
        assertEquals("Nature & Ecology", nonFictionBook.getTopic());
    }

    @Test
    void setTopic() {
        nonFictionBook.setTopic("History");
        assertEquals("History", nonFictionBook.getTopic());
    }

    @Test
    void getBookType() {
        String expectedBookType = "Traditional Book";
        assertEquals(expectedBookType, nonFictionBook.getBookType());
    }

    @Test
    void testToString() {
        String expected = "Non-Fiction Book - ISBN: 978-1455574112, Title: The Hidden Life of Trees, Author: Peter Wohlleben, Number of Pages: 288, Year Published: 2016, Topic: Nature & Ecology";
        assertEquals(expected, nonFictionBook.toString());
    }
}