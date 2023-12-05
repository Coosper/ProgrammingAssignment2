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
        return
                "History Book - ISBN: " + getISBN() +
                        ", Title: " + getTitle() +
                        ", Author: " + getAuthor() +
                        ", Number of Pages: " + getNumOfPages() +
                        ", Year Published: " + getYearPublished() +
                        ", Topic: " + getTopic() +
                        ", Book Era: " + getEra();

    }

    @Override
    public String getEdition() {
        return super.getEdition();
    }
}
