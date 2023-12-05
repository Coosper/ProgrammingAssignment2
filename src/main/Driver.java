package main;

import controllers.*;
import models.*;
import utils.*;

public class Driver {
    private LibrarySystemAPI library;
    public Driver() {
        library = new LibrarySystemAPI();
    }

    public static void main(String [] args) {
        Driver app = new Driver();
        app.runMenu();
    }

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

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

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
        int pages = ScannerInput.readNextInt("Enter the number of pages: " );
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
        System.out.println("\n\u001B[32mBook Added Successfully\u001B[0m");
        System.out.println();
    }

    private void removeBook() {
        System.out.println(library.listOfBooks());
    }
}






