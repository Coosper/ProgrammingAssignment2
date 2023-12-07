package models;

public class NonFiction extends TraditionalBook {
    String topic;

    /**
     * A constructor for the NonFiction Book
     * It inherits some attributes from its Superclass and takes in new ones.
     *
     * @param bookTitle The Books Title
     * @param bookAuthor The Books Author
     * @param bookISBN The Books ISBN
     * @param numberOfPages THe number of pages the book has
     * @param yearPublished The Year the book was published
     * @param topic The books topic
     */
    public NonFiction(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String topic) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished);
        this.topic = topic;
    }

    /**
     * A method to get the books topic.
     *
     * @return The books topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * A method to set the books topic.
     *
     * @param topic The books new topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
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
     * This method returns the details of the books in a single String.
     * It overrides the method from the Book superclass. Displaying details exclusive to an NonFiction Book.
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
                        ", Year Published: " + getYearPublished() +
                        ", Topic: " + getTopic();

    }
}
