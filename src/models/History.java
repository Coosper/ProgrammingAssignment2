package models;

public class History extends NonFiction {
    private String era;

    /**
     * A constructor for a History book.
     * It inherits some attributes from its Superclass and takes in new ones.
     *
     * @param bookTitle The Books Title
     * @param bookAuthor The Books Author
     * @param bookISBN The Books ISBN
     * @param numberOfPages THe number of pages the book has
     * @param yearPublished The Year the book was published
     * @param topic The books topic
     * @param era The Era the book is set in.
     */
    public History(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String topic, String era) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished, topic);
        this.era = era;
    }


    /**
     * A method to get the books Era
     *
     * @return The Books Era
     */
    public String getEra() {
        return era;
    }

    /**
     * Returns the type of book.
     * Overrides the method from the Book superclass.
     *
     * @return The books type.
     */
    @Override
    public String getBookType() {
        return super.getBookType();
    }

    /**
     * A method to set the books era.
     *
     * @param era The books new era.
     */
    public void setEra(String era) {
        this.era = era;
    }

    /**
     * This method returns the details of the books in a single String.
     * It overrides the method from the Book superclass. Displaying details exclusive to an History Book.
     *
     * @return The books details.
     */
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
