package com.upGrad.DAO;

import com.upGrad.beans.Account;

import java.util.HashMap;

public interface AccountDAO {
    public Account acceptAccountDetails(Account account) ;
    public Account getAccountDetails(int accountNumber) throws Exception;
    public Account updateAccountDetails(Account account) throws Exception;
}
