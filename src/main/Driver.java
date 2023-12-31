package main;

import controllers.*;
import models.*;
import utils.*;

public class Driver {

    private LibrarySystemAPI library;

    /**
     * Constructor for the Driver class.
     *
     * This constructor initializes the Driver object by creating a new instance
     * of the LibrarySystemAPI class.
     */
    public Driver() {
        library = new LibrarySystemAPI();
    }

    public static void main(String[] args) {
        Driver app = new Driver();
        app.runMenu();
    }

    /**
     * This method displays a menu to the user.
     * It asks the user to enter a int number depending on their choice
     *
     * @return It returns the users choice.
     */
    private int mainMenu() {
        int num;
        System.out.println("------------------");
        System.out.println("   Library Menu");
        System.out.println("------------------");
        System.out.println("1). Add Book");
        System.out.println("2). Remove Book");
        System.out.println("3). List All Books");
        System.out.println("------------------");
        System.out.println("4). Display a book by ISBN");
        System.out.println("5). Display a book by Title");
        System.out.println("6). Display a book by Author");
        System.out.println("------------------");
        System.out.println("7). Display all books by ISBN");
        System.out.println("8). Display all books by Title");
        System.out.println("9). Display all books by Author");
        System.out.println("------------------");
        System.out.println("10). List all books by a key word");
        System.out.println("11). List all books in alphabetic order");
        System.out.println("12). Show edition of each book");
        System.out.println("------------------");
        System.out.println("13). Save details");
        System.out.println("14). Load details");
        System.out.println("------------------");
        System.out.println("0). Exit");
        num = ScannerInput.readNextInt("===> ");
        return num;
    }

    /**
     * This method displays the main menu, processes whatever choice the user made
     * by calling the corresponding methods.
     * It handles invalid choices and allows the user to exit by pressing 0.
     */
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    getBookByIsbn();
                    break;
                case 5:
                    getBookByTitle();
                    break;
                case 6:
                    getBookByAuthor();
                    break;
                case 7:
                    getAllBooksByIsbn();
                    break;
                case 8:
                    getAllBooksByTitle();
                    break;
                case 9:
                    getAllBooksByAuthor();
                    break;
                case 10:
                    searchBookByWord();
                    break;
                case 11:
                    showInAlphabeticalOrder();
                    break;
                case 12:
                    showEdition();
                    break;
                case 13:
                    saveData();
                    break;
                case 14:
                    loadData();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Invalid option entered: " + option);
                    break;
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            ScannerInput.readNextLine("");

            option = mainMenu();
        }
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    /**
     * This methods allows the addition of new books to the library.
     * It immediately asks the user which type of book they'd like to create.
     * It takes in the information shared by all books and then uses a switch to take in additional information shared by different book types.
     * It adds these books to the library and displays a success message.
     */
    private void addBook() {
        System.out.println("Which book type would you like to add?");
        System.out.println("1). eBook");
        System.out.println("2). Fiction Book");
        System.out.println("3). Geography Book");
        System.out.println("4). History Book");
        int option = ScannerInput.readNextInt("Please enter (1-4) only: ");

        if (option < 1 || option > 4) {
            System.err.println("Invalid option. Please enter a number between 1 and 4.");
            return;
        }

        System.out.println();
        String isbn = ScannerInput.readNextLine("Enter ISBN: ");
        String title = ScannerInput.readNextLine("Enter Title: ");
        String author = ScannerInput.readNextLine("Enter the Author: ");
        int pages = ScannerInput.readNextInt("Enter the number of pages: ");
        if (pages <= 0) {
            System.err.println("The number of pages cannot be negative");
            return;
        }
        switch (option) {
            case 1:
                char isInteractive = ScannerInput.readNextChar("Is the book interactive? (y/n): ");
                boolean isInteractive1 = false;
                if ((isInteractive == 'Y') || (isInteractive == 'y')) {
                    isInteractive1 = true;
                }
                library.addBook(new Ebook(title, author, isbn, pages, isInteractive1));
                break;
            case 2:
                int yearPublished = ScannerInput.readNextInt("Enter publication year: ");
                String genre = ScannerInput.readNextLine("Enter the book genre: ");

                library.addBook(new FictionBook(title, author, isbn, pages, yearPublished, genre));
                break;
            case 3:
                int yearPublishedGeography = ScannerInput.readNextInt("Enter publication date: ");
                String geographyTopic = ScannerInput.readNextLine("Enter the book topic: ");
                System.out.println("  Geography Elements Options");
                System.out.println("1). The World In Spatial Terms");
                System.out.println("2). Places and regions");
                System.out.println("3). Physical Systems");
                System.out.println("4). Human Systems");
                int elementChoice = ScannerInput.readNextInt("Enter geography element (1-4): ");
                library.addBook(new Geography(title, author, isbn, pages, yearPublishedGeography, geographyTopic, elementChoice));
                break;
            case 4:
                int yearHistoryPublished = ScannerInput.readNextInt("Enter publication date: ");
                String historyTopic = ScannerInput.readNextLine("Enter book topic: ");
                String historyEra = ScannerInput.readNextLine("Enter history book era: ");

                library.addBook(new History(title, author, isbn, pages, yearHistoryPublished, historyTopic, historyEra));
            default:
                System.out.println("");
                break;
        }
        System.out.println();
        System.out.println("\n\u001B[32mBook Added Successfully!\u001B[0m");
        System.out.println();
    }


    /**
     * This method starts off by printing out ALL of the books within the library
     * It then asks the user to enter the index of the book they wish to delete.
     * If there is a book at that index number it is deleted from the library and displays a fitting error message if there isn't.
     */
    private void removeBook() {
        System.out.println(library.listOfBooks());

        if (library.numberOfBooks() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the book to delete: ");

            if ((index >= 0) && (index < library.numberOfBooks())) {
                library.removeBook(index);
                System.out.println();
                System.out.println("\n\u001B[32mBook Deleted Successfully!\u001B[0m");
                System.out.println();
            } else {
                System.err.println("There is no book at this index number!");
            }
        }
    }

    /**
     * This method first checks if there are any books in the library.
     * If there are it displays all of the books.
     * If there isn't any then it displays that there are no books saved.
     */
    private void displayAllBooks() {
        if (library.numberOfBooks() != 0) {
            System.out.println(library.listOfBooks());
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method retrieves a book from the library based on its ISBN
     * It checks whether the library has any book within it to begin with.
     */
    private void getBookByIsbn() {
        if (library.numberOfBooks() != 0) {
            String isbnToSearchBy = ScannerInput.readNextLine("Enter the ISBN of the book you want to view: ");
            isbnToSearchBy = isbnToSearchBy.toLowerCase();

            if (library.getBookByIsbn(isbnToSearchBy) != null) {
                System.out.println("Books found: ");
                System.out.println((library.getBookByIsbn(isbnToSearchBy).toString()));
            } else {
                System.err.println("No books with the ISBN '" + isbnToSearchBy + "' was found in the library.");
            }
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method retrieves a book from the library based on its Title.
     */
    private void getBookByTitle() {
        if (library.numberOfBooks() != 0) {
            String titleToSearchBy = ScannerInput.readNextLine("Enter the Title of the book you want to view: ");
            titleToSearchBy = titleToSearchBy.toLowerCase();

            if (library.getBookByTitle(titleToSearchBy) != null) {
                System.out.println("Books found: ");
                System.out.println((library.getBookByTitle(titleToSearchBy).toString()));
            } else {
                System.err.println("No books with the title '" + titleToSearchBy + "' was found in the library.");
            }
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method retrieves a book from the library based on its Author.
     */
    private void getBookByAuthor() {
        if (library.numberOfBooks() != 0) {
            String authorToSearchBy = ScannerInput.readNextLine("Enter the author of the book you want to view: ");
            authorToSearchBy = authorToSearchBy.toLowerCase();

            if (library.getBookByAuthor(authorToSearchBy) != null) {
                System.out.println("Books found: ");
                System.out.println((library.getBookByAuthor(authorToSearchBy).toString()));
            } else {
                System.err.println("No books with the author '" + authorToSearchBy + "' was found in the library.");
            }
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method retrieves ALL books based on their ISBN
     */
    public void getAllBooksByIsbn() {
        if (library.numberOfBooks() != 0) {
            String isbnToSearchBy = ScannerInput.readNextLine("Enter the ISBN to search by: ");
            String result = library.getBooksByIsbn(isbnToSearchBy);
            System.out.println("Books found: ");
            System.out.println(result);
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method retrieves ALL books based on their title.
     */
    public void getAllBooksByTitle() {
        if (library.numberOfBooks() != 0) {
            String titleToSearchBy = ScannerInput.readNextLine("Enter the ISBN to search by: ");
            String result = library.getBooksByTitle(titleToSearchBy);
            System.out.println("Books found: ");
            System.out.println(result);
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method retrieves ALL books based on their Author.
     */
    public void getAllBooksByAuthor() {
        if (library.numberOfBooks() != 0) {
            String authorToSearchBy = ScannerInput.readNextLine("Enter the author to search by: ");
            String result = library.getBooksByAuthor(authorToSearchBy);
            System.out.println("Books found: ");
            System.out.println(result);
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method retrieves the info of books based on a inputted Keyword.
     */
    public void searchBookByWord() {
        if (library.numberOfBooks() != 0) {
            String keywordToSearchBy = ScannerInput.readNextLine("Enter the keyword to search by: ");
            String result = library.searchWord(keywordToSearchBy);
            System.out.println("Books found: ");
            System.out.println(result);
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method checks whether the library is empty.
     * If there are books within it, it displays all the books in alphabetical order.
     */
    public void showInAlphabeticalOrder() {
        if (library.numberOfBooks() != 0) {
            System.out.println("Books in alphabetical order");
            System.out.println(library.alphabeticalOrder());
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * This method checks whether the library is empty.
     * If there are books within it, it displays all of the books titles and editions.
     */
    private void showEdition() {
        if(library.numberOfBooks() != 0) {
            System.out.println(library.showEditionOfEachBook());
        } else {
            System.err.println("There are no books saved in the library");
        }
    }

    /**
     * Saves the library to an .xml file.
     * If an error occurs it displays an error message.
     * If the save is succesful it displays a success message.
     */
    private void saveData() {
        try {
            library.save();
        } catch (Exception e) {
            System.err.println("Error writing to file " + e);
        }
        System.out.println();
        System.out.println("\n\u001B[32mSave Successful!!\u001B[0m");
        System.out.println();
    }

    /**
     * It loads the library from the books.xml file.
     * If an error occurs it displays an error message.
     * If the save is succesful it displays a success message.
     */
    private void loadData() {
        try {
            library.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
        System.out.println();
        System.out.println("\n\u001B[32mLoad Successful!!\u001B[0m");
        System.out.println();
    }

}










