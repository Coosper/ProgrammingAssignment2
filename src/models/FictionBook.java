package models;

public class FictionBook extends TraditionalBook {
    private String genre;
    public FictionBook(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String genre) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished);
        this.genre = genre;
    }

    @Override
    public String getBookType() {
        return super.getBookType();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Fiction Book - ISBN: " + getISBN() +
                ", Title: " + getTitle() +
                ", Author: " + getAuthor() +
                ", No. of Pages: " + getNumOfPages() +
                ", Year Published: " + getYearPublished() +
                ", Genre: " + getGenre();
    }

    @Override
    public String getEdition() {
        return super.getEdition();
    }
}
