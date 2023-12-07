package models;

public class TraditionalBook extends Book {
    int yearPublished;

    /**
     * A constructor for the TraditionalBook Book
     * It inherits some attributes from its Superclass and takes in new ones.
     *
     * @param bookTitle The Books Title
     * @param bookAuthor The Books Author
     * @param bookISBN The Books ISBN
     * @param numberOfPages THe number of pages the book has
     * @param yearPublished The Year the book was published
     */
    public TraditionalBook(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages);
        this.yearPublished = yearPublished;
    }

    /**
     * A method which returns the publication year.
     *
     * @return Publication Year.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * A method to set the publication year.
     *
     * @param yearPublished The books new publication year.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Returns the type of book.
     * Overrides the method from the Book superclass.
     *
     * @return The books type.
     */
    @Override
    public String getBookType() {
        return "Traditional Book";
    }

    /**
     * This method returns the details of the books in a single String.
     * It overrides the method from the Book superclass. Displaying details exclusive to an Traditional Book.
     *
     * @return The books details.
     */
    @Override
        public String toString() {
            return
                    "Non-Fiction Book - ISBN: " + getISBN() +
                            ", Title: " + getTitle() +
                            ", Author: " + getAuthor() +
                            ", Number of Pages: " + getNumOfPages() +
                            ", Year Published: " + getYearPublished();

    }
}
