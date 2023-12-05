package models;

public class Geography extends NonFiction {
    int elements;
    public Geography(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String topic, int elements) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished, topic);
        this.elements = elements;
    }

    public String getElements() {
        return null;
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
        System.out.print("E-Book");
        System.out.println("\nBook Title: " + getTitle());
        System.out.println("\nBook Author: " + getAuthor());
        System.out.println("\nBook ISBN: " + getISBN());
        System.out.println("\nNumber of Pages: " + getNumOfPages());
        System.out.println("\nYear Published: " + getYearPublished());
        System.out.println("\nBook Topic: " + getTopic());
        System.out.println("\nBook Elements: " + getElements());
        return null;
    }

    @Override
    public String getEdition() {
        return super.getEdition();
    }
}
