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
        InteractivityStatus = interactivity;
    }

    @Override
    public String getBookType() {
        return "E-Book";
    }

    @Override
    public String toString() {
        System.out.print("E-Book");
        System.out.println("\nBook Title: " + getTitle());
        System.out.println("\nBook Author: " + getAuthor());
        System.out.println("\nBook ISBN: " + getISBN());
        System.out.println("\nNumber of Pages: " + getNumOfPages());
        System.out.println("\nInteractive: " + getInteractivity());
        return null;
    }

    @Override
    public String getEdition() {
        return super.getEdition();
    }

}
