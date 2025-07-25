package com.aurionpro.inheritance;

import java.util.Comparator;

public class AccountNumberComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        return Integer.compare(a1.getAccNO(), a2.getAccNO());
    }
}

