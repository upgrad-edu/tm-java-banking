package com.upGrad.service;

import com.upGrad.beans.Account;

public interface AccountService {
    public Account acceptAccountDetails(Account account) ;
    public Account getAccountDetails(int accountNumber, int pin) ;
    public Account depositAmount(int accountNumber, int amount);
    public Account withdrawAmount(int accountNumber, int pin, int amount) ;
}
