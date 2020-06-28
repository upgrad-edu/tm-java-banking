package com.upGrad;

import com.upGrad.beans.Account;
import com.upGrad.service.AccountServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        AccountServiceImpl bankServices = new AccountServiceImpl();
        System.out.println("Kindly chose your option ");
        while (flag) {
            System.out.println("Please chose an option: ");
            System.out.println("1. Create a new account ");
            System.out.println("2. Deposit money in an account");
            System.out.println("3. Withdraw money from an account");
            System.out.println("4. Get Account Details");
            System.out.println("5. Calculate EMI");
            System.out.println("6. Exit");
            Scanner sc = new Scanner(System.in);
            int switchKey = sc.nextInt();
            switch (switchKey) {
                case 1:
                    System.out.println("**CREATING NEW ACCOUNT**");
                    System.out.println("Please enter your details");
                    System.out.println("Please enter your name");
                    sc.nextLine();
                    String accountHolderName = sc.nextLine();
                    System.out.println("Please enter your account number ");
                    int accountNumber = sc.nextInt();
                    System.out.println("Please enter starting balance");
                    int startingBalance = sc.nextInt();
                    System.out.println("Please enter your pin");
                    int pin = sc.nextInt();
                    sc.nextLine();
                    Account newAccount = new Account(accountHolderName, accountNumber, startingBalance, pin);
                    bankServices.acceptAccountDetails(newAccount);
                    break;

                case 2:
                    System.out.println("****DEPOSIT MONEY IN ACCOUNT****");
                    System.out.println("Enter your account number");
                    int myAccount = sc.nextInt();
                    System.out.println("Enter the amount you want to deposit");
                    int depAmount = sc.nextInt();
                    int newAmount = bankServices.depositAmount(myAccount, depAmount).getCurrentBalance();
                    System.out.println("Transaction successful \nUpdated Balance  :" + newAmount);
                    break;

                case 3:
                    System.out.println("****WITHDRAW MONEY FROM ACCOUNT****");
                    System.out.println("Enter your account number");
                    int tempAccount = sc.nextInt();
                    System.out.println("Enter the amount you want to Withdraw");
                    int withAmount = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo = sc.nextInt();
                    Account account = bankServices.withdrawAmount(tempAccount, pinNo, withAmount);
                    if (account == null) {
                        System.out.println("Invalid operation");
                    } else {
                        int newAmount1 = bankServices.getAccountDetails(tempAccount, pinNo).getCurrentBalance();
                        System.out.println("Transaction successful \nUpdated Balance : " + newAmount1);
                    }
                    break;

                case 4:
                    System.out.println("*****ACCOUNT DETAILS********");
                    System.out.println("Enter your account number");
                    int accNo = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo1 = sc.nextInt();
                    Account accountDetails = bankServices.getAccountDetails(accNo, pinNo1);
                    if (accountDetails == null) {
                        System.out.println("******Invalid account number or pin******");
                    } else {
                        System.out.println("Welcome to your account : " + accountDetails.getAccountHolderName());
                        System.out.println("Current balance : " + accountDetails.getCurrentBalance());
                    }
                    break;
                case 5:
                    System.out.println("******CALCULATE EMI*******");
                    //future feature to be implemented
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
