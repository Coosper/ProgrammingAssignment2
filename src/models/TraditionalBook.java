package models;

public class TraditionalBook extends Book {
    int yearPublished;
    public TraditionalBook(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages);
        this.yearPublished = yearPublished;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String getBookType() {
        return "Traditional Book";
    }

    @Override
    public String toString() {
        System.out.print("E-Book");
        System.out.println("\nBook Title: " + getTitle());
        System.out.println("\nBook Author: " + getAuthor());
        System.out.println("\nBook ISBN: " + getISBN());
        System.out.println("\nNumber of Pages: " + getNumOfPages());
        System.out.println("\nYear Published: " + getYearPublished());
        return null;
    }
}
