package com.upGrad.beans;

import com.upGrad.utils.AccountValidator;

public class Account implements AccountValidator {
    private String accountHolderName;
    private int accountNumber;
    private int currentBalance;
    private int pin;


    public Account(String accountHolderName, int accountNumber, int currentBalance, int pin) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.pin = pin;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public boolean isValid() {
        System.out.println("Validating account");
        if(accountNumber <= 0)
            return false;
        else
            return true;
    }
}
