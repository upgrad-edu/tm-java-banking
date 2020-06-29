package com.upGrad.beans;

public class SavingsAccount extends Account {
    private boolean freeTransactions;

    public SavingsAccount(String accountHolderName, int accountNumber, int currentBalance, int pin) {
        super(accountHolderName, accountNumber, currentBalance, pin);
    }

    public boolean isFreeTransactions() {
        return freeTransactions;
    }

    public void setFreeTransactions(boolean freeTransactions) {
        this.freeTransactions = freeTransactions;
    }


}
