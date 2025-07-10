package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;
import com.aurionpro.model.Account;
import com.aurionpro.model.AccountType;

public class AccountTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[10];
        int accountCount = 0;

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create New Account");
            System.out.println("2. View Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                if (accountCount >= accounts.length) {
                    System.out.println("Account limit reached.");
                    break;
                }

                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter account type (Savings/Current): ");
                String typeInput = sc.nextLine();

                AccountType accountType = null;
                if (typeInput.equalsIgnoreCase("saving")) {
                    accountType = AccountType.Savings;
                } else if (typeInput.equalsIgnoreCase("current")) {
                    accountType = AccountType.Current;
                } else {
                    System.out.println("Invalid account type. Account not created.");
                    break;
                }

                String accNo = "IDBI1000" + (new Random().nextInt(9000) + 1000);
                Account acc = new Account(accNo, name, accountType);
                accounts[accountCount] = acc;
                accountCount++;

                System.out.println("Account Created!");
                System.out.println(acc);
                break;

            case 2:
                System.out.print("Enter Account No: ");
                String searchNo = sc.nextLine();
                Account foundAcc = findAccount(accounts, searchNo, accountCount);
                if (foundAcc != null) {
                    System.out.println("Balance: " + foundAcc.getBalance());
                } else {
                    System.out.println("Account not found.");
                }
                break;

            case 3:
                System.out.print("Enter Account No: ");
                String depNo = sc.nextLine();
                Account depAcc = findAccount(accounts, depNo, accountCount);
                if (depAcc != null) {
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = sc.nextDouble();
                    sc.nextLine();
                    depAcc.depositAmount(depositAmt);
                } else {
                    System.out.println("Account not found.");
                }
                break;

            case 4:
                System.out.print("Enter Account No: ");
                String witNo = sc.nextLine();
                Account witAcc = findAccount(accounts, witNo, accountCount);
                if (witAcc != null) {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmt = sc.nextDouble();
                    sc.nextLine();
                    witAcc.withdrawAmount(withdrawAmt);
                } else {
                    System.out.println("Account not found.");
                }
                break;

            case 5:
                System.out.println("Thank you for using our bank system!");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    public static Account findAccount(Account[] accArr, String accNo, int count) {
        for (int i = 0; i < count; i++) {
            if (accArr[i].getAccountNumber().equals(accNo)) {
                return accArr[i];
            }
        }
        return null;
    }
}
