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

/**
 * LibrarySystemAPI method.
 */
public class LibrarySystemAPI {
    private ArrayList<Book> allBooks;
    private Map<String, Book> booksbyIsbn;
    private Map<String, Book> booksbyAuthor;
    private Map<String, Book> booksByTitle;

    /**
     * The LibrarySystemAPI constructor, it instantiates the allBooks ArrayList, booksByIsbn Hashmap, booksByAuthor Hashmap and the booksByTitle Hashmap
     */
    public LibrarySystemAPI() {
        allBooks = new ArrayList<>();
        booksbyIsbn = new HashMap<>();
        booksbyAuthor = new HashMap<>();
        booksByTitle = new HashMap<>();

    }

    /**
     * The Getter method for getBooksByIsbn
     *
     * @return booksbyIsbn
     */
    public Map<String, Book> getBooksbyIsbn() {
        return booksbyIsbn;
    }

    /**
     *
     * The getter method for returning books by their author.
     *
     * @return booksByAuthor, all the books according to their author.
     */
    public Map<String, Book> getBooksbyAuthor() {
        return booksbyAuthor;
    }

    /**
     * A getter method for returning the books by their title.
     *
     * @return booksByTitle
     */
    public Map<String, Book> getBooksByTitle() {
        return booksByTitle;
    }

    /**
     * This method adds a book to the allBooks arraylist AND to all the relevant hashmaps.
     *
     * @param tempBook The Book to be added.
     */
    public void addBook(Book tempBook) {
        allBooks.add(tempBook);
        booksbyIsbn.put(tempBook.getISBN(), tempBook);
        booksByTitle.put(tempBook.getTitle(), tempBook);
        booksbyAuthor.put(tempBook.getAuthor(), tempBook);
    }

    /**
     * This method removes a book from the library based on its index within the arraylist.
     *
     * @param index The index of the book to be removed.
     * @throws IllegalArgumentException An error if the provided index is invalid. (Less than 0);
     */
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

    /**
     * This method first checks to see if there are any books in the allBooks arraylist.
     * If there are it returns a fitting error message.
     * If there are books in the ArrayList then it iterates through each book, calling it's toString and adding it onto the end result String.
     *
     * @return the full list of books as a string.
     */
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

    /**
     * A simple method which to check the total amount of books in the array.
     *
     * @return the total amount of books in the allBooks arrayList.
     */
    public int numberOfBooks() {
        return allBooks.size();
    }

    /**
     * This method generates a string containing all the non-fiction books found in the library's collection.
     *
     *
     * @return A string listing all the non-fiction books OR a message saying that there are none in the library.
     */
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

    /**
     * A method that generates a string containing fiction books found in the library's collection.
     *
     * @return A string listing all the fiction books OR a message saying that there are none in the library.
     */
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

    /**
     * A method that generates a string containing Geography books found in the library's collection.
     *
     * @return A string listing all the Geography books OR a message saying that there are none in the library.
     */
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

    /**
     * A method that generates a string containing History books found in the library's collection.
     *
     * @return A string listing all the History books OR a message saying that there are none in the library.
     */
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

    /**
     * A method that generates a string containing all E-Books found in the library's collection.
     *
     * @return A string listing all E-books OR a message saying that there are none in the library.
     */
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

    /**
     * This method searches for books in the library based on a single word.
     *
     * @param wordToSearchBy The word to search the library by.
     * @return A string containing all books with that word or a message that no such books have been found.
     */
    public String searchWord(String wordToSearchBy) {
        String result = "";
        for (Book book : allBooks) {
            if (
                    book.getTitle().toUpperCase().contains(wordToSearchBy.toUpperCase()) ||
                    book.getAuthor().toUpperCase().contains(wordToSearchBy.toUpperCase()) ||
                    book.getISBN().toUpperCase().contains(wordToSearchBy.toUpperCase())) {
                result += book.toString() + "\n";
            }
        }

        if (result.isEmpty()) {
            return "No books have been found with the word " + wordToSearchBy + " in the title.";
        } else {
            return result;
        }
    }

    /**
     * Searches for a book based on its ISBN
     *
     * @param isbnToSearchFor the ISBN to search by.
     * @return The book with that ISBN.
     */
    public Book getBookByIsbn(String isbnToSearchFor) {
        return booksbyIsbn.get(isbnToSearchFor);
    }

    /**
     * Searches for a book based on its Title.
     *
     * @param titleToSearchFor The title to search by.
     * @return The book with that title.
     */
    public Book getBookByTitle(String titleToSearchFor) {
        return booksByTitle.get(titleToSearchFor);
    }

    /**
     * Searches for a book based on its Author.
     *
     * @param authorToSearchBy The Author to search by.
     * @return The book with that Author.
     */
    public Book getBookByAuthor(String authorToSearchBy) {
        return booksbyAuthor.get(authorToSearchBy);
    }

    /**
     * This method searches for multiple books based on ISBN
     *
     * @param isbnToSearchBy The ISBN to search for.
     * @return A string listing all the matching books, or a message if no matches are found.
     */
    public String getBooksByIsbn(String isbnToSearchBy) {
        String matchingIsbn = "";
        for (Book book : allBooks) { //Looping through all the books in the collection.
            if (book.getISBN().toUpperCase().contains(isbnToSearchBy.toUpperCase())) { //Checking if the book has the ISBN, ignoring case.
                matchingIsbn += book.toString() + "\n"; //Attaches the book's toString to the result if it matches.
            }
        }
        if (matchingIsbn.equals("")) {
            return "No books by '" + matchingIsbn + "' have been found in the library.";
        } else {
            return matchingIsbn;
        }
    }

    /**
     * This method searches for multiple books based on its ISBN.
     *
     * @param titleToSearchBy The title to search by.
     * @return A string listing all the matching books. Or an error meesage if no matches are found.
     */
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

    /**
     * This methods sorts and returns a collection of books in an alphabetical order.
     *
     * @return The string listing all books in alphabetical order.
     */
    public String alphabeticalOrder() {
        for (int i = allBooks.size() - 1; i >= 0; i--) { //Looping backwards through the list.
            int highestIndex = 0;

            for (int j = 0; j <= i; j++) { //We find the index with the highest alphabetical title.
                if (allBooks.get(j).getTitle().compareTo(allBooks.get(highestIndex).getTitle()) > 0) {
                    highestIndex = j;
                }
            }
            Utilities.swapBooks(allBooks, i, highestIndex); //Here we swap the book found with the book at 'i'.
        }
        String alphabeticalResult = "";
        int counter = 1;
        //Finally we loop through all the books and create a string with their titles in the right order.
        for (Book book : allBooks) {
            alphabeticalResult += counter + "). " + book.getTitle() + "\n";
            counter++;
        }
        return alphabeticalResult;
    }

    /**
     * This method generates a string listing the title and edition of each book within the library.
     *
     *
     * @return A string with each books title and edition.
     */
    public String showEditionOfEachBook() {
        String editionAndTitle = "";
        int counter = 1;
        for (Book book : allBooks) {
            editionAndTitle += counter + "). " + book.getTitle() + " - Edition: " + book.getEdition() + "\n";
            counter++;
        }
        return editionAndTitle;
    }

    /**
     * Saves the current library to an .xml file.
     * The file is created or overwritten each time.
     *
     * @throws Exception If there is an error while saving.
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("books.xml"));
        out.writeObject(allBooks);
        out.close();
    }

    /**
     * This loads the library state through the books.xml file
     *
     * @throws Exception If there is an error while loading.
     */
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
