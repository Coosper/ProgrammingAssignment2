package models;

public class History extends NonFiction {
    private String era;

    public History(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String topic, String era) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished, topic);
        this.era = era;
    }


    public String getEra() {
        return era;
    }

    @Override
    public String getBookType() {
        return super.getBookType();
    }

    public void setEra(String era) {
        this.era = era;
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
        System.out.println("\nBook Era" + getEra());
        return null;
    }

    @Override
    public String getEdition() {
        return super.getEdition();
    }
}
