package com.upGrad;

import com.upGrad.DAO.AccountDAO;
import com.upGrad.DAO.AccountDAOImpl;
import com.upGrad.beans.Account;
import com.upGrad.service.AccountServiceImpl;
import com.upGrad.utils.EMICalculator;

import java.util.Scanner;

public class Main {
    //this is the main, which will be called at the beginning of the program
    public static void main(String[] args) throws Exception {
        AccountDAO accountDAO = new AccountDAOImpl();
        boolean flag = true;
        AccountServiceImpl bankServices = new AccountServiceImpl(accountDAO);
        System.out.println("Kindly chose your option ");
        while (flag) { //below we have all the options given with their numbers and descriptions
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
                case 1: //we will use this case to create new account and will accept account details
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
                    int myAccountNumber = sc.nextInt();
                    System.out.println("Enter the amount you want to deposit");
                    int depAmount = sc.nextInt();
                    int newAmount = bankServices.depositAmount(myAccountNumber, depAmount).getCurrentBalance();
                    System.out.println("Transaction successful \nUpdated Balance  :" + newAmount);
                    break;

                case 3:
                    System.out.println("****WITHDRAW MONEY FROM ACCOUNT****");
                    System.out.println("Enter your account number");
                    int tempAccountNumber = sc.nextInt();
                    System.out.println("Enter the amount you want to Withdraw");
                    int withAmount = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo = sc.nextInt();
                    Account account = bankServices.withdrawAmount(tempAccountNumber, pinNo, withAmount);
                    if (account == null) {
                        System.out.println("Invalid operation");
                    } else {
                        int newAmount1 = bankServices.getAccountDetails(tempAccountNumber, pinNo).getCurrentBalance();
                        System.out.println("Transaction successful \nUpdated Balance : " + newAmount1);
                    }
                    break;

                case 4:
                    System.out.println("*****ACCOUNT DETAILS********");
                    System.out.println("Enter your account number");
                    int accNo = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNumber = sc.nextInt();
                    Account accountDetails = bankServices.getAccountDetails(accNo, pinNumber);
                    if (accountDetails == null) {
                        System.out.println("******Invalid account number or pin******");
                    } else {
                        System.out.println("Welcome to your account : " + accountDetails.getAccountHolderName());
                        System.out.println("Current balance : " + accountDetails.getCurrentBalance());
                    }
                    break;
                case 5:
                    System.out.println("******CALCULATE EMI*******");
                    System.out.println("Enter total amount");
                    int totalAmount = sc.nextInt();
                    System.out.println("Enter total months");
                    int totalMonths = sc.nextInt();
                    System.out.println("EMI amount " + EMICalculator.calculateEMIAmount(totalAmount,totalMonths));
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
