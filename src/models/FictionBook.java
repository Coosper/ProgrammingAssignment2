package models;

public class FictionBook extends TraditionalBook {
    private String genre;

    /**
     * The FictionBook constructor.
     * It inherits basic book properties as well as taking in some book specific ones.
     *
     * @param bookTitle The book title
     * @param bookAuthor The books Author
     * @param bookISBN The books ISBN
     * @param numberOfPages The amount of pages in the book
     * @param yearPublished The year the book was published
     * @param genre The books Genre.
     */
    public FictionBook(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished, String genre) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages, yearPublished);
        this.genre = genre;
    }

    /**
     * Returns the type of book.
     * Overrides the method from the Book superclass.
     *
     * @return The books type.
     */
    @Override
    public String getBookType() {
        return "Fiction Book";
    }

    /**
     * This method returns the books genre.
     *
     * @return The Books Genre.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * This method sets the books genre to a new one.
     *
     * @param genre The new genre.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * This method returns the details of the books in a single String.
     * It overrides the method from the Book superclass. Displaying details exclusive to an FictionBook.
     *
     * @return The books details.
     */
    @Override
    public String toString() {
        return "Fiction Book - ISBN: " + getISBN() +
                ", Title: " + getTitle() +
                ", Author: " + getAuthor() +
                ", No. of Pages: " + getNumOfPages() +
                ", Year Published: " + getYearPublished() +
                ", Genre: " + getGenre();
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
