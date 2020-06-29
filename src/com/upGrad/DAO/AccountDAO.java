package com.upGrad.DAO;

import com.upGrad.beans.Account;
import com.upGrad.exceptions.AccountDetailsNotFoundException;

import java.util.HashMap;

public interface AccountDAO {
    public Account acceptAccountDetails(Account account) ;
    public Account getAccountDetails(int accountNumber) throws AccountDetailsNotFoundException;
    public Account updateAccountDetails(Account account) throws AccountDetailsNotFoundException;
}
