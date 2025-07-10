package com.aurionpro.test;

import com.aurionpro.model.*;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookStore store = new BookStore();

        while (true) {
            System.out.println("\n--- Book Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book by ID");
            System.out.println("3. Display Available Books");
            System.out.println("4. Display Issued Books");
            System.out.println("5. Return Book by ID");
            System.out.println("6. Sort Books:");
            System.out.println("   1. Ascending by Author");
            System.out.println("   2. Descending by Title");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    store.addbook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    store.issuebook(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Available Books:");
                    store.displayAvailableBooks();
                    break;
                case 4:
                    System.out.println("Issued Books:");
                    store.displayIssuedBooks();
                    break;
                case 5:
                    System.out.print("Enter Book ID to return: ");
                    store.returnbook(sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Sort Option (1-Author / 2-Title): ");
                    int sortChoice = sc.nextInt();
                    if (sortChoice == 1) {
                        store.sortByAuthor();
                    } else if (sortChoice == 2) {
                        store.sortByTitleDescending();
                    } else {
                        System.out.println("Invalid sort choice.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
