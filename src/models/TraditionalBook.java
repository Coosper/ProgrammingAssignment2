package models;

public class TraditionalBook extends Book {
    int yearPublished;
    public TraditionalBook(String bookTitle, String bookAuthor, String bookISBN, int numberOfPages, int yearPublished) {
        super(bookTitle, bookAuthor, bookISBN, numberOfPages);
        this.yearPublished = yearPublished;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String getBookType() {
        return "Traditional Book";
    }

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
