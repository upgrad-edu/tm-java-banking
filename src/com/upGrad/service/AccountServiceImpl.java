package com.upGrad.service;

import com.upGrad.DAO.AccountDAO;
import com.upGrad.DAO.AccountDAOImpl;
import com.upGrad.beans.Account;

public class AccountServiceImpl implements  AccountService{

    private AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account acceptAccountDetails(Account account) {
        return accountDAO.acceptAccountDetails(account);
    }

    public Account getAccountDetails(int accountNumber, int pin) throws Exception {
        Account myAccount = accountDAO.getAccountDetails(accountNumber);
        if (myAccount == null) {
            System.out.println("Account not found");
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

    public Account depositAmount(int accountNumber, int amount) throws Exception {
        Account account = accountDAO.getAccountDetails(accountNumber);
        if(account == null){
            System.out.println("Account not found");
        }else{
            account.setCurrentBalance(account.getCurrentBalance() + amount);
            accountDAO.updateAccountDetails(account);
        }
        return account;
    }

    public Account withdrawAmount(int accountNumber, int pin, int amount) throws Exception {
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


}
