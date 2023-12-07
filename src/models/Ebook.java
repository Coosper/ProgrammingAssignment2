package models;

public class Ebook extends Book {
    private boolean interactivity;

    public Ebook(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, boolean interactivity) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages);
        this.interactivity = interactivity;
    }

    public boolean getInteractivity() {
        return interactivity;
    }

    public void setInteractivity(boolean InteractivityStatus) {
        interactivity = InteractivityStatus;
    }

    @Override
    public String getBookType() {
        return "E-Book";
    }

    @Override
    public String toString() {
        return
                "E-Book - ISBN: " + getISBN() +
                ", Title: " + getTitle() +
                ", Author: " + getAuthor() +
                ", No. of Pages: " + getNumOfPages() +
                ", Interactivity: " + getInteractivity();
    }

    @Override
    public String getEdition() {
        return super.getEdition();
    }

}
