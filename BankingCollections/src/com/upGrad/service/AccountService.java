package com.upGrad.service;

import com.upGrad.beans.Account;

import java.util.HashMap;
import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account loginAccount(int accountNumber, int pin);
    public Account addAmount(int accountNumber, int amount);
    public Account getAmount(int accountNumber, int pin, int amount);
    public boolean deleteAccount(Account account);
    public HashMap<Integer,Account> getAllAccounts();
}
