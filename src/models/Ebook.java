package models;

public class Ebook extends Book {
    private boolean interactivity;

    /**
     * The EBook constructor.
     * It inherits basic book properties as well as taking in some book specific ones.
     *
     * @param bookTitle The Book Title
     * @param bookAuthor The Book Author
     * @param bookISBN The Books ISBN
     * @param numberOfPages The Number of pages it has
     * @param interactivity A boolean value whether the book is interactive or not
     */
    public Ebook(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, boolean interactivity) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages);
        this.interactivity = interactivity;
    }

    /**
     * A getter method returning the books interactivity
     *
     * @return The Books Interactivity
     */
    public boolean getInteractivity() {
        return interactivity;
    }

    /**
     * A setter method which changes the books interactivity.
     *
     * @param InteractivityStatus The books new interactivity.
     */
    public void setInteractivity(boolean InteractivityStatus) {
        interactivity = InteractivityStatus;
    }

    /**
     * Returns the type of book.
     * Overrides the method from the Book superclass.
     *
     * @return The books type.
     */
    @Override
    public String getBookType() {
        return "E-Book";
    }

    /**
     * This method returns the details of the books in a single String.
     * It overrides the method from the Book superclass. Displaying details exclusive to an Ebook.
     *
     * @return The books details.
     */
    @Override
    public String toString() {
        return
                "E-Book - ISBN: " + getISBN() +
                ", Title: " + getTitle() +
                ", Author: " + getAuthor() +
                ", No. of Pages: " + getNumOfPages() +
                ", Interactivity: " + getInteractivity();
    }

    /**
     * A method to return the book edition.
     *
     * @return Its edition pulled from a super class.
     */
    @Override
    public String getEdition() {
        return super.getEdition();
    }

}
