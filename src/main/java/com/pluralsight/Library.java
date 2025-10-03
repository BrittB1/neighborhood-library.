package com.pluralsight;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        Book[] books = new Book[20];

        Scanner keyboard = new Scanner(System.in);
        boolean running = true;

        books[0] = new Book(1, "12345", "The Tale of Despereaux");
        books[1] = new Book(2, "12346", "The Lightning Thief");
        books[2] = new Book(3, "12347", "Charlotte's Web");
        books[3] = new Book(4, "12348", "A Series of Unfortunate Events: The Bad Beginning");
        books[4] = new Book(5, "12349", "A Series of Unfortunate Events: The Reptile Room");
        books[5] = new Book(6, "12310", "The Lion, the Witch and the Wardrobe");
        books[6] = new Book(7, "12314", "James and the Giant Peach");
        books[7] = new Book(8, "12389", "Stuart Little");
        books[8] = new Book(9, "12409", "Matilda");
        books[9] = new Book(10, "12128", "Alice in Wonderland");
        books[10] = new Book(11, "1297", "Fantastic Mr.Fox");
        books[11] = new Book(12, "12300", "The Jungle Book");
        books[12] = new Book(13, "12338", "The Wizard of Oz");
        books[13] = new Book(14, "12377", "Charlie and the Chocolate Factory");
        books[14] = new Book(15, "19870", "A Christmas Carol");
        books[15] = new Book(16, "11276", "Hatchet");
        books[16] = new Book(17, "19997", "I Know Why the Caged Bird Sings");
        books[17] = new Book(18, "18874", "Old Yeller");
        books[18] = new Book(19, "14321", "The Outsiders");
        books[19] = new Book(20, "15432", "To Kill a Mockingbird");

        while (running) {

            String choice = displayMenu(keyboard);

            switch (choice) {
                case "A":
                    showAvailableBooks(books, keyboard);
                    break;
                case "C":
                    showCheckedOutBooks(books, keyboard);
                    break;

                case "X":
                    running = false;
                    System.out.println("Thank you for using the Library System. Come back soon! \uD83D\uDC4B");
                    break;
            }
        }
    }

    private static void showAvailableBooks(Book[] books, Scanner keyboard) {
        System.out.println("\n ==== Available Books ===");

        for (int i = 0; i < books.length; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.println("ID: "
                        + books[i].getId() + "| ISBN: "
                        + books[i].getIsbn() + "| Title: "
                        + books[i].getTitle());
            }
        }
        System.out.println("\n Options: ");
        System.out.println(" Check out a book by ID: ");
        System.out.println("H - Back to Home Screen");
        System.out.print("Please enter an option: ");

        String bookChoice = keyboard.nextLine().toUpperCase();

        if ((!bookChoice.equals("H"))) {
            int bookId = Integer.parseInt(bookChoice);

            System.out.println("Enter your name: ");
            String name = keyboard.nextLine();

            for (Book book : books) {
                if (book.getId() == bookId) {
                    book.checkOut(name);
                    System.out.println("Book check-out successful. Happy reading!");
                    break;

                }
            }
        }
    }
        private static void showCheckedOutBooks (Book[]books, Scanner keyboard){
            for (Book book : books) {
                if (book.isCheckedOut()) {
                    System.out.println("ID: "
                            + book.getId() + " | ISBN: "
                            + book.getIsbn() + " | Title: "
                            + book.getTitle() + " | Checked out to: "
                            + book.getCheckedOutTo());
                }
            }
            System.out.println("\n Options: ");
            System.out.println("C - Check in a book by ID");
            System.out.println("H - Back to Home Screen");
            System.out.print("Please enter an option: ");

            String checkedOutChoice = keyboard.nextLine().toUpperCase();

            if (checkedOutChoice.equals("C")) {
                System.out.print("Please enter the Book ID to check in: ");
                int bookId = Integer.parseInt(keyboard.nextLine());

                for (int j = 0; j < books.length; j++) {
                    if (books[j].getId() == bookId) {
                        books[j].checkIn();
                        System.out.println("✅ Book check-in successful");
                        break;
                    }
                }
            }
        }
        private static String displayMenu (Scanner keyboard){
            System.out.println("""
                         =====================================
                              🌞 Welcome to the Library!  📚
                         =====================================
                         Please select an option to get started:
                        \s
                         A. Available Books
                         C. Checked Out Books
                         X. Exit
                    \s""");
            System.out.print("Enter your choice: ");
            return keyboard.nextLine().toUpperCase();
        }
}