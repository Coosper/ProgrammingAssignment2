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
        return
                "Non-Fiction Book - ISBN: " + getISBN() +
                        ", Title: " + getTitle() +
                        ", Author: " + getAuthor() +
                        ", Number of Pages: " + getNumOfPages() +
                        ", Year Published: " + getYearPublished() +
                        ", Topic: " + getTopic();

    }
}
