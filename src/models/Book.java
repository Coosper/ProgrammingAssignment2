package models;

import main.*;

public abstract class Book extends Reading {
    private String title;
    private String author;
    private String ISBN;
    private int numOfPages;
    private boolean isAvailable;

    public Book(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages) {
        this.title = bookTitle;
        this.author = bookAuthor;
        this.ISBN = bookISBN;
        this.numOfPages = numberOfPages;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumOfPages() {
        return numOfPages;
    }
    public String getISBN() {
        return ISBN;
    }

    public String toString() {
        System.out.println("\nBook Title: " + title);
        System.out.println("\nBook Author: " + author);
        System.out.println("\nISBN: " + ISBN);
        System.out.println("\nNumber of Pages: " + numOfPages);
        return null;
    }

    public String getBookType() {
        return "General";
    }
}
