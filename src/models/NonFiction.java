package models;

public class NonFiction extends TraditionalBook {
    String topic;

    public NonFiction(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String topic) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
        return null;
    }
}
