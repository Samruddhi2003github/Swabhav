package com.aurionpro.inheritance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Account> accounts = new ArrayList<>();
		CurrentAccount current = new CurrentAccount(101, "Samruddhi", 5000, 2000);
		SavingsAccount savings = new SavingsAccount(102, "Anagha", 10000, 3000);
		CurrentAccount current1 = new CurrentAccount(100, "Prajakta", 2000, 1000);
		SavingsAccount savings1 = new SavingsAccount(111, "Gayatri", 10000, 3000);

		accounts.add(current);
		accounts.add(savings);
		accounts.add(current1);

//        CurrentAccount current = new CurrentAccount(101, "Samruddhi", 5000, 2000);
//        SavingsAccount savings = new SavingsAccount(102, "Srushti", 10000, 3000);

//        int choice;
//        do {
//            System.out.println("\n--- Menu ---");
//            System.out.println("1. Credit to Current Account");
//            System.out.println("2. Debit from Current Account");
//            System.out.println("3. Display Current Account");
//            System.out.println("4. Credit to Savings Account");
//            System.out.println("5. Debit from Savings Account");
//            System.out.println("6. Display Savings Account");
//            System.out.println("7. Exit");
//            System.out.print("Enter your choice: ");
//            choice = sc.nextInt();
//
//            try {
//                switch (choice) {
//                    case 1:
//                        System.out.print("Enter amount to credit: ");
//                        current.credit(sc.nextDouble());
//                        break;
//                    case 2:
//                        System.out.print("Enter amount to debit: ");
//                        current.debit(sc.nextDouble());
//                        break;
//                    case 3:
//                        current.display();
//                        break;
//                    case 4:
//                        System.out.print("Enter amount to credit: ");
//                        savings.credit(sc.nextDouble());
//                        break;
//                    case 5:
//                        System.out.print("Enter amount to debit: ");
//                        savings.debit(sc.nextDouble());
//                        break;
//                    case 6:
//                        savings.display();
//                        break;
//                    case 7:
//                        System.out.println("Exiting...");
//                        break;
//                    default:
//                        System.out.println("Invalid choice!");
//                }
//            } catch (NegativeAmountException | InsufficientBalanceException | OverdraftLimitExceededException e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//
//        } while (choice != 7);
//        
//
//        sc.close();

		System.out.println("Sorted by Balance :");
		Collections.sort(accounts);
		for (Account acc : accounts)
			acc.display();

		System.out.println("\nSorted by Name:");
		Collections.sort(accounts, new NameComparator());
		for (Account acc : accounts)
			acc.display();

		System.out.println("\nSorted by Account Number:");
		Collections.sort(accounts, new AccountNumberComparator());
		for (Account acc : accounts)
			acc.display();
	}
}
