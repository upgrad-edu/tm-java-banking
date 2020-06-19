package com.upGrad.service;

import com.upGrad.DAO.AccountDAO;
import com.upGrad.DAO.AccountDAOImpl;
import com.upGrad.beans.Account;

import java.util.HashMap;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    AccountDAO accountDAO = new AccountDAOImpl();
    @Override
    public Account createAccount(Account account) {
        return accountDAO.createAccount(account);
    }

    @Override
    public Account loginAccount(int accountNumber, int pin) {
        Account tempAccount = accountDAO.getAccount(accountNumber);
        if(tempAccount == null) {
            System.out.println("Account does not exists");
            return null;
        }else{
            if(tempAccount.getPin() == pin){
                System.out.println("Details are correct : login to account");
                return tempAccount;
            }else{
                System.out.println("Incorrect pin ");
                return null;
            }
        }
    }

    @Override
    public Account addAmount(int accountNumber, int amount) {
        Account account = accountDAO.getAccount(accountNumber);
        account.setCurrentBalance(account.getCurrentBalance()+amount);
        accountDAO.updateAccount(account);
        return account;
    }

    @Override
    public Account getAmount(int accountNumber, int pin, int amount) {
        Account myaccount = loginAccount(accountNumber, pin);
        if(myaccount == null) {
            return null;
        }else{
            int currentBalance = myaccount.getCurrentBalance();
            if(currentBalance<amount) {
            System.out.println("Not enough balance");
            return myaccount;
        }else{
            myaccount.setCurrentBalance(myaccount.getCurrentBalance() - amount);
            return accountDAO.updateAccount(myaccount);
        }
        }
    }

    @Override
    public boolean deleteAccount(Account account) {
       return accountDAO.deleteAccount(account);
    }

    @Override
    public HashMap<Integer,Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }
}
