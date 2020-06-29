package com.upGrad.service;

import com.upGrad.beans.Account;

public interface AccountService {
    public Account acceptAccountDetails(Account account) ;
    public Account getAccountDetails(int accountNumber, int pin) throws Exception;
    public Account depositAmount(int accountNumber, int amount) throws Exception;
    public Account withdrawAmount(int accountNumber, int pin, int amount) throws Exception;
}
