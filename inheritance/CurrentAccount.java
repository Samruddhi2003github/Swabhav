package com.aurionpro.inheritance;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(int accno, String name, double balance, double overdraftLimit) {
        super(accno, name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void debit(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Cannot debit negative or zero amount.");
        }

        if (amount <= (getBalance() + overdraftLimit)) {
            setBalance(getBalance() - amount);
            System.out.println("Amount debited: Rs. " + amount);
        } else {
            throw new OverdraftLimitExceededException("Overdraft limit exceeded.");
        }
    }

    public void display() {
        super.display();
        System.out.println("Overdraft Limit: ₹" + overdraftLimit);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
