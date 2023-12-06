package controllers;
import models.*;
import utils.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


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
            if (
                    book.getTitle().toUpperCase().contains(wordToSearchBy.toUpperCase()) ||
                    book.getAuthor().toUpperCase().contains(wordToSearchBy.toUpperCase()) ||
                    book.getISBN().toUpperCase().contains(wordToSearchBy.toUpperCase())) {
                result += book.toString();
            }
        }

        if (result.isEmpty()) {
            return "No books have been found with the word " + wordToSearchBy + " in the title.";
        } else {
            return result;
        }
    }

    public Book getBookByIsbn(String isbnToSearchFor) {
        return booksbyIsbn.get(isbnToSearchFor);
    }

    public Book getBookByTitle(String titleToSearchFor) {
        return booksByTitle.get(titleToSearchFor);
    }

    public Book getBookByAuthor(String authorToSearchBy) {
        return booksbyAuthor.get(authorToSearchBy);
    }

    public String getBooksByIsbn(String isbnToSearchBy) {
        String matchingIsbn = "";
        for (Book book : allBooks) {
            if (book.getISBN().toUpperCase().contains(isbnToSearchBy.toUpperCase())) {
                matchingIsbn += book.toString() + "\n";
            }
        }
        if (matchingIsbn.equals("")) {
            return "No books by '" + matchingIsbn + "' have been found in the library.";
        } else {
            return matchingIsbn;
        }
    }

    public String getBooksByTitle(String titleToSearchBy) {
        String matchingTitle = "";
        for (Book book : allBooks) {
            if (book.getTitle().toUpperCase().contains(titleToSearchBy.toUpperCase())) {
                matchingTitle += book.toString() + ".\n";
            }
        }
        if (matchingTitle.equals("")) {
            return "No books by '" + matchingTitle + "' have been found in the library.";
        } else {
            return matchingTitle;
        }
    }

    public String getBooksByAuthor(String authorToSearchBy) {
        String matchingAuthor = "";
        for (Book book : allBooks) {
            if (book.getAuthor().toUpperCase().contains(authorToSearchBy.toUpperCase())) {
                matchingAuthor += book.toString() + ".\n";
            }
        }
        if (matchingAuthor.equals("")) {
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
        int counter = 1;
        for (Book book : allBooks) {
            alphabeticalResult += counter + "). " + book.getTitle() + "\n";
            counter++;
        }
        return alphabeticalResult;
    }

    public String showEditionOfEachBook() {
        String editionAndTitle = "";
        int counter = 1;
        for (Book book : allBooks) {
            editionAndTitle += counter + "). " + book.getTitle() + " - Edition: " + book.getEdition() + "\n";
            counter++;
        }
        return editionAndTitle;
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("books.xml"));
        out.writeObject(allBooks);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] {Book.class, Ebook.class, FictionBook.class, Geography.class, History.class, NonFiction.class, TraditionalBook.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("books.xml"));
        allBooks = (ArrayList<Book>) in.readObject();
        in.close();
    }
}
