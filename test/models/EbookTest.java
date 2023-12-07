package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EbookTest {

    private Ebook ebook1, ebook2;

    @BeforeEach
    void setUp() {
        //Name: Test Title, Author: Test Author ISBN: Test ISBN PageNumber: 100 Interactivity: true
        ebook1 = new Ebook("Test Title", "Test Author", "Test ISBN", 100, true);
        //Name: Man Of Glass, Author: Gaunter O'Dimm, ISBN: 1933948G, PageNumber: 150, Interactivity: false
        ebook2 = new Ebook("Man Of Glass", "Gaunter O'Dimm", "1933948G", 150, false);
    }


    @Test
    void getInteractivity() {
        assertTrue(ebook1.getInteractivity());
        assertFalse(ebook2.getInteractivity());
    }

    @Test
    void SetInteractivity() {
        ebook1.setInteractivity(false);
        ebook2.setInteractivity(true);

        assertFalse(ebook1.getInteractivity());
        assertTrue(ebook2.getInteractivity());
    }

    @Test
    void getBookType() {
        assertEquals("E-Book", ebook1.getBookType(), "ebook1 should be of type E-Book");
        assertEquals("E-Book", ebook2.getBookType(), "ebook2 should be of type E-Book");
    }

    @Test
    void testToString() {
        String expected1 = "E-Book - ISBN: Test ISBN, Title: Test Title, Author: Test Author, No. of Pages: 100, Interactivity: true";
        assertEquals(expected1, ebook1.toString(), "ebook1 toString method should match the expected format");

        String expected2 = "E-Book - ISBN: 1933948G, Title: Man Of Glass, Author: Gaunter O'Dimm, No. of Pages: 150, Interactivity: false";
        assertEquals(expected2, ebook2.toString(), "ebook2 toString method should match the expected format");
    }

    @Test
    void testGetEdition() {
        String expectedEdition = "This is the latest edition of this book.";
        assertEquals(expectedEdition, ebook1.getEdition());
        assertEquals(expectedEdition, ebook2.getEdition());
    }
}