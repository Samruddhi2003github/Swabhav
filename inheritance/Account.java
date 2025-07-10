package com.aurionpro.inheritance;


public abstract class Account implements Comparable<Account> {
    private int accNO;
    private String name;
    private double balance;

    public Account(int accNO, String name, double balance) {
        this.accNO = accNO;
        this.name = name;
        this.balance = balance;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Cannot credit negative or zero amount.");
        }
        balance += amount;
        System.out.println("Amount credited: Rs. " + amount);
    }

    public abstract void debit(double amount);

    public void display() {
        System.out.println("Account number: " + accNO);
        System.out.println("Name: " + name);
        System.out.println("Balance: Rs. " + balance);
    }

    public int getAccNO() {
        return accNO;
    }

    public void setAccNO(int accNO) {
        this.accNO = accNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public int compareTo(Account other) {
        return Double.compare(this.balance, other.balance);
    }
}

