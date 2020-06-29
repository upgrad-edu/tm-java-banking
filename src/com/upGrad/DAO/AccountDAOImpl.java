package com.upGrad.DAO;

import com.upGrad.beans.Account;
import com.upGrad.exceptions.AccountDetailsNotFoundException;

import java.util.HashMap;

public class AccountDAOImpl implements AccountDAO{
    Account[] accounts = new Account[10];
    int numberOfAccounts = 0;
    int maxNumberOfAccounts = accounts.length;

    public Account acceptAccountDetails(Account account) {
        if(numberOfAccounts<maxNumberOfAccounts){
            accounts[numberOfAccounts] = account;
            numberOfAccounts++;
            return account;
        }else{
            System.out.println("Number of possible accounts is full ");
            return null;
        }
    }

    public Account getAccountDetails(int accountNumber) throws AccountDetailsNotFoundException {
        Account account = null;
        for(Account acc : accounts){
            if(acc.getAccountNumber() == accountNumber ){
                return acc;
            }
        }
        System.out.println("Account for the given number does not exist");
        throw new AccountDetailsNotFoundException("Account details not found for accoutNumber: "+ accountNumber);
    }

    public Account updateAccountDetails(Account account) throws Exception {
        Account myAccount = null;
        int position = 0;
        for(int i=0;i<maxNumberOfAccounts;i++){
            if(accounts[i].getAccountNumber() == account.getAccountNumber() ){
                myAccount = accounts[i];
                position = i;
                break;
            }
        }
        if(myAccount==null)
            throw new AccountDetailsNotFoundException("Account not found exception for account number:" + account.getAccountNumber());
        else
            return account;
    }

}
