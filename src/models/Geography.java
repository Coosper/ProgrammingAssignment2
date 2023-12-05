package models;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class Geography extends NonFiction {
    int elements;
    public Geography(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String topic, int elements) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished, topic);
        this.elements = elements;
    }

    public String getElements() {
        Map<Integer, String> elementsMap = new HashMap<>();
        elementsMap.put(1, "The World in Spatial Terms");
        elementsMap.put(2, "Places and Regions");
        elementsMap.put(3, "Physical System");
        elementsMap.put(4, "Human Systems");

        return elementsMap.getOrDefault(elements, "Unknown");
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

    @Override
    public String getBookType() {
        return super.getBookType();
    }

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

    @Override
    public String getEdition() {
        return super.getEdition();
    }
}
