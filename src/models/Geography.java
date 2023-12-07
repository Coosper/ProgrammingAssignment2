package models;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class Geography extends NonFiction {
    int elements;

    /**
     * The Geography Book constructor
     * It inherits basic book properties as well as taking in some book specific ones.
     *
     * @param bookTitle The Books Title
     * @param bookAuthor The Books Author
     * @param bookISBN The Books ISBN
     * @param numberOfPages THe number of pages the book has
     * @param yearPublished The Year the book was published
     * @param topic The books topic
     * @param elements The elements of the book.
     */
    public Geography(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String topic, int elements) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished, topic);
        this.elements = elements;
    }

    /**
     * This method retrieves a geographic element based on its number.
     * It maps the numbers to their element using a Hashmap.
     *
     * @return A string representing the element chosen or "Unknown".
     */
    public String getElements() {
        Map<Integer, String> elementsMap = new HashMap<>();
        elementsMap.put(1, "The World in Spatial Terms");
        elementsMap.put(2, "Places and Regions");
        elementsMap.put(3, "Physical System");
        elementsMap.put(4, "Human Systems");

        return elementsMap.getOrDefault(elements, "Unknown");
    }

    /**
     * This method changes the elements integer.
     *
     * @param elements New element integer.
     */
    public void setElements(int elements) {
        this.elements = elements;
    }

    /**
     * Returns the type of book.
     * Overrides the method from the Book superclass.
     *
     * @return The books type.
     */
    @Override
    public String getBookType() {
        return super.getBookType();
    }

    /**
     * This method returns the details of the books in a single String.
     * It overrides the method from the Book superclass. Displaying details exclusive to an Geography Book.
     *
     * @return The books details.
     */
    @Override
    public String toString() {
        return
                "Geography Book - ISBN: " + getISBN() +
                ", Title: " + getTitle() +
                ", Author: " + getAuthor() +
                ", Number of Pages: " + getNumOfPages() +
                ", Year Published: " + getYearPublished() +
                ", Topic: " + getTopic() +
                ", Book Elements: " + getElements();
    }

    /**
     * A method to return the book edition.
     *
     * @return Its edition pulled from a super class.
     */
    @Override
    public String getEdition() {
        return super.getEdition();
    }
}
