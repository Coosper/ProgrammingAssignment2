package controllers;
import models.*;
import utils.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystemAPI {
    private ArrayList<Book> allBooks;
    private Map<String, Book> booksbyIsbn;
    private Map<String, Book> booksbyAuthor;
    private Map<String, Book> booksByTitle;

    public LibrarySystemAPI() {
        allBooks = new ArrayList<>();
        booksbyIsbn = new HashMap<>();
        booksbyAuthor = new HashMap<>();
        booksByTitle = new HashMap<>();

    }

    public Map<String, Book> getBooksbyIsbn() {
        return booksbyIsbn;
    }

    public Map<String, Book> getBooksbyAuthor() {
        return booksbyAuthor;
    }

    public Map<String, Book> getBooksByTitle() {
        return booksByTitle;
    }

    public void addBook(Book tempBook) {
        allBooks.add(tempBook);
        booksbyIsbn.put(tempBook.getISBN(), tempBook);
        booksByTitle.put(tempBook.getTitle(), tempBook);
        booksbyAuthor.put(tempBook.getAuthor(), tempBook);
    }

    public void removeBook(int index) throws IllegalArgumentException {
        if (index > 0 || index >= allBooks.size()) {
            throw new IllegalArgumentException("Invalid Index!");
        } else {
            Book bookToRemove = allBooks.get(index);
            allBooks.remove(index);
            booksbyIsbn.remove(bookToRemove.getISBN());
            booksByTitle.remove(bookToRemove.getTitle());
            booksbyAuthor.remove(bookToRemove.getAuthor());
        }
    }

    public String listOfBooks() {
        if (allBooks.isEmpty()) {
            return "There are no books stored.";
        } else {
            String result = "";
            for (int i = 0; i < allBooks.size(); i++) {
                result += i + "): " + allBooks.get(i).toString() + "\n";
            }
            return result;
        }
    }

    public int numberOfBooks() {
        return allBooks.size();
    }

    public String showNonFictionBooks() {
        String result = "";
        for (Book book : allBooks) {
            if (book instanceof NonFiction) {
                result += book.toString() + "\n";
            }
        }

        if (result.isEmpty()) {
            return "There are no non-fiction books in the library.";
        } else {
            return result;
        }
    }

    public String showFictionBooks() {
        String result = "";
        for (Book book : allBooks) {
            if (book instanceof FictionBook) {
                result += book.toString() + "\n";
            }
        }

        if (result.isEmpty()) {
            return "There are no fiction books in the library.";
        } else {
            return result;
        }
    }

    public String showGeographyBooks() {
        String result = "";
        for (Book book : allBooks) {
            if (book instanceof Geography) {
                result += book.toString() + "\n";
            }
        }

        if (result.isEmpty()) {
            return "There are no geography books in the library.";
        } else {
            return result;
        }
    }

    public String showHistoryBooks() {
        String result = "";
        for (Book book : allBooks) {
            if (book instanceof History) {
                result += book.toString() + "\n";
            }
        }

        if (result.isEmpty()) {
            return "There are no history books in the library.";
        } else {
            return result;
        }
    }

    public String showEbooksBooks() {
        String result = "";
        for (Book book : allBooks) {
            if (book instanceof Ebook) {
                result += book.toString() + "\n";
            }
        }

        if (result.isEmpty()) {
            return "There are no ebooks in the library.";
        } else {
            return result;
        }
    }

    public String searchWord(String wordToSearchBy) {
        String result = "";
        for (Book book : allBooks) {
            if (book.getTitle().toLowerCase().contains(wordToSearchBy.toLowerCase())) {
                result += book.toString();
            }
        }

        if(result.isEmpty()) {
            return "No books have been found with the word " + wordToSearchBy + " in the title.";
        } else {
            return result;
        }
    }

    public Book getBookByIsbn(String isbnToSearchFor) {
        return booksbyIsbn.get(isbnToSearchFor);
    }

    public Book getBookTitle(String titleToSearchFor) {
        return booksByTitle.get(titleToSearchFor);
    }

    public Book getBookByAuthor(String authorToSearchBy) {
        return booksbyAuthor.get(authorToSearchBy);
    }

    public String getBooksByIsbn(String isbnToSearchBy) {
        String matchingIsbn = "";
        for (Book book : allBooks) {
            if (book.getISBN().toUpperCase().contains(isbnToSearchBy.toUpperCase())) {
                matchingIsbn  += "Title: " + book.getISBN() + ".\n";
            }
        }
        if(matchingIsbn.equals("")) {
            return "No books by '" + matchingIsbn  + "' have been found in the library.";
        } else {
            return matchingIsbn ;
        }
    }

    public String getBooksByTitle(String titleToSearchBy) {
        String matchingTitle = "";
        for (Book book : allBooks) {
            if (book.getTitle().toUpperCase().contains(titleToSearchBy.toUpperCase())) {
                matchingTitle  += "Title: " + book.getTitle() + ".\n";
            }
        }
        if(matchingTitle.equals("")) {
            return "No books by '" + matchingTitle  + "' have been found in the library.";
        } else {
            return matchingTitle ;
        }
    }

    public String getBooksByAuthor(String authorToSearchBy) {
        String matchingAuthor = "";
        for (Book book : allBooks) {
            if (book.getAuthor().toUpperCase().contains(authorToSearchBy.toUpperCase())) {
                matchingAuthor += "Title: " + book.getAuthor() + ".\n";
            }
        }
        if(matchingAuthor.equals("")) {
            return "No books by '" + authorToSearchBy + "' have been found in the library.";
        } else {
            return matchingAuthor;
        }
    }

    public String alphabeticalOrder() {
        for (int i = allBooks.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (allBooks.get(j).getTitle().compareTo(allBooks.get(highestIndex).getTitle()) > 0) {
                    highestIndex = j;
                }
            }
            Utilities.swapBooks(allBooks, i, highestIndex);
        }
        String alphabeticalResult = "";
        for (Book book : allBooks) {
            alphabeticalResult += book.getTitle() + "\n";
        }
        return alphabeticalResult;
    }

    public String showEditionOfEachBook() {
        String editionAndTitle = "";
        int counter = 1;
        for (Book book : allBooks) {
            editionAndTitle += counter + "). " + book.getTitle() + " - Edition: " + book.getEdition();
            counter++;
        }
        return editionAndTitle;
    }
}
