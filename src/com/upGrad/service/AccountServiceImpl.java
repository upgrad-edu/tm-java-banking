package com.upGrad.service;

import com.upGrad.DAO.AccountDAOImpl;
import com.upGrad.beans.Account;

public class AccountServiceImpl {

    AccountDAOImpl accountDAO = new AccountDAOImpl();

    public Account acceptAccountDetails(Account account) {
        return accountDAO.acceptAccountDetails(account);
    }

    public Account getAccountDetails(int accountNumber, int pin) {
        Account myAccount = accountDAO.getAccountDetails(accountNumber);
        if (myAccount == null) {
            System.out.println("Account does not exists");
            return null;
        } else {
            if (myAccount.getPin() == pin) {
                System.out.println("Details are correct : login to account");
                return myAccount;
            } else {
                System.out.println("Incorrect pin ");
                return null;
            }
        }
    }

    public Account depositAmount(int accountNumber, int amount) {
        Account account = accountDAO.getAccountDetails(accountNumber);
        if(account == null){
            System.out.println("Account not found");
        }else{
            account.setCurrentBalance(account.getCurrentBalance() + amount);
            accountDAO.updateAccountDetails(account);
        }
        return account;
    }

    public Account withdrawAmount(int accountNumber, int pin, int amount) {
        Account myAccount = getAccountDetails(accountNumber, pin);
        if (myAccount == null) {
            System.out.println("Account not found");
            return null;
        } else {
            int currentBalance = myAccount.getCurrentBalance();
            if (currentBalance < amount) {
                System.out.println("Not enough balance");
                return myAccount;
            } else {
                myAccount.setCurrentBalance(myAccount.getCurrentBalance() - amount);
                return accountDAO.updateAccountDetails(myAccount);
            }
        }
    }

    public static int calculateEMIAmount(int totalAmount, int months){
        //we will add emi calculation functionality here
        return 0;
    }

    public static int calculateNumberOfEMIs(int totalAmount, int emiAmount){
        //we will add emi calculation functionality here
        return 0;
    }

}
