package com.upGrad.DAO;

import com.upGrad.beans.Account;

import java.util.HashMap;
import java.util.List;

public interface AccountDAO {
    public Account createAccount(Account account);
    public Account getAccount(int accountNumber);
    public Account updateAccount(Account account);
    public boolean deleteAccount(Account account);
    public HashMap<Integer,Account> getAllAccounts();
}
