package models;

import main.*;

public class Book extends Reading {
    private String title;
    private String author;
    private String ISBN;
    private int numOfPages;
    private boolean isAvailable;

    /**
     * The constructor for Book
     *
     * @param bookTitle The title of the book
     * @param bookAuthor The Author of the Book
     * @param bookISBN The Books ISBN
     * @param numberOfPages The number of pages in the book.
     */
    public Book(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages) {
        this.title = bookTitle;
        this.author = bookAuthor;
        this.ISBN = bookISBN;
        this.numOfPages = numberOfPages;

    }

    /**
     * A getter method for the bookTitle
     *
     * @return Title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * A getter method for the bookAuthor
     *
     * @return Author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * A getter method for the NumOfPages
     *
     * @return Amount of pages in the book
     */
    public int getNumOfPages() {
        return numOfPages;
    }

    /**
     * A getter method for the books ISBN
     *
     * @return The books ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * This method returns the details of the books in a single String.
     *
     * @return The books details.
     */
    public String toString() {
        return
                "E-Book - ISBN: " + getISBN() +
                        ", Title: " + getTitle() +
                        ", Author: " + getAuthor() +
                        ", No. of Pages: " + getNumOfPages();
    }

    /**
     * A method to get the Books type.
     *
     * @return The Book Type.
     */
    public String getBookType() {
        return "General";
    }
}
