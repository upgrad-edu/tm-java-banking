package com.upGrad.DAO;

import com.upGrad.beans.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AccountDAOImpl implements AccountDAO{
    HashMap<Integer,Account> accountHashMap = new HashMap<>();

    @Override
    public Account createAccount(Account account) {
       if(accountHashMap.containsKey(account.getAccountNumber())){
           System.out.println("This account number already exists");
           return account;
       }else{
           accountHashMap.put(account.getAccountNumber(), account);
           System.out.println("Congrats! Your account has been created");
           return account;
       }
    }

    @Override
    public Account getAccount(int accountNumber) {
        Account tempAccount = accountHashMap.get(accountNumber);
        if(tempAccount == null)
            System.out.println("Account does not exist");
        else
            System.out.println("Account details: ");
        return tempAccount;
    }

    @Override
    public Account updateAccount(Account account) {
        accountHashMap.put(account.getAccountNumber(),account);
        return account;
    }

    @Override
    public boolean deleteAccount(Account account) {
       Account temp =   accountHashMap.remove(account.getAccountNumber());
        return true;
    }

    @Override
    public HashMap<Integer,Account> getAllAccounts() {
       return  accountHashMap;
    }
}
