package com.aurionpro.inheritance;

public class SavingsAccount extends Account {
    private double minBalance;

    public SavingsAccount(int accNO, String name, double balance, double minBalance) {
        super(accNO, name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void debit(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Cannot debit negative or zero amount.");
        }

        if ((getBalance() - amount) >= minBalance) {
            setBalance(getBalance() - amount);
            System.out.println("Amount debited: ₹" + amount);
        } else {
            throw new InsufficientBalanceException("Debit failed. Minimum balance rule violated!");
        }
    }

    public void display() {
        super.display();
        System.out.println("Minimum Balance Required: Rs. " + minBalance);
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}
