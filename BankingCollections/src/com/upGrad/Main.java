package com.upGrad;

import com.upGrad.beans.Account;
import com.upGrad.service.AccountService;
import com.upGrad.service.AccountServiceImpl;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        AccountService bankServices = new AccountServiceImpl();
        System.out.println("Kindly chose your option ");
        while(flag)
        {
            System.out.println("Please chose an option: ");
            System.out.println("1. Create a new account ");
            System.out.println("2. Deposit money in an account");
            System.out.println("3. Withdraw money from an account");
            System.out.println("4. Fund Transfer");
            System.out.println("5. Get Account Details");
            System.out.println("6. Show all accounts");
            System.out.println("7. Exit");
            Scanner sc = new Scanner(System.in);
            int switchKey = sc.nextInt();
            switch(switchKey)
            {
                case 1 : System.out.println("**CREATING NEW ACCOUNT**");
                    System.out.println("Please enter your details");
                    System.out.println("Please enter your name");
                    sc.nextLine();
                    String accountHolderName = sc.nextLine();
                    System.out.println("Please enter your account number ");
                    int  accountNumber = sc.nextInt();
                    System.out.println("Please enter starting balance");
                    int startingBalance = sc.nextInt();
                    System.out.println("Please enter your pin");
                    int pin = sc.nextInt();
                    sc.nextLine();
                    Account newAccount = new Account(accountHolderName, accountNumber, startingBalance,pin);
                    bankServices.createAccount(newAccount);
                    break;

                case 2 : System.out.println("****DEPOSIT MONEY IN ACCOUNT****");
                    System.out.println("Enter your account number");
                    int acc1 = sc.nextInt();
                    System.out.println("Enter the amount you want to deposit");
                    int depAmount = sc.nextInt();
                    int newAmount = bankServices.addAmount(acc1, depAmount).getCurrentBalance();
                    System.out.println("Transaction successful \nUpdated Balance  :" + newAmount);
                    break;

                case 3 : System.out.println("****WITHDRAW MONEY FROM ACCOUNT****");
                    System.out.println("Enter your account number");
                    int acc2 = sc.nextInt();
                    System.out.println("Enter the amount you want to Withdraw");
                    int withAmount = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo = sc.nextInt();
                    Account account = bankServices.getAmount(acc2, withAmount, pinNo);
                    if(account == null){
                        System.out.println("Invalid operation");
                    }else{
                        int newAmount1 = bankServices.getAmount(acc2, withAmount, pinNo).getCurrentBalance();
                        System.out.println("Transaction successful \nUpdated Balance" + newAmount1);
                    }
                    break;

                case 4:
                    System.out.println("This feature has yet to be added ");
                    break;
    /*
                    case 4 : System.out.println("*****FUND TRANSFER*****");
                    System.out.println("Enter your account number");
                    long accountNoFrom = sc.nextLong();
                    System.out.println("Enter amount you want to transfer");
                    float transferAmount = sc.nextFloat();
                    System.out.println("Enter account number to transfer");
                    long accountNoTo = sc.nextLong();
                    System.out.println("Enter your pin number");
                    int pinNumber = sc.nextInt();
                    boolean success = bankServices.fundTransfer(accountNoTo, accountNoFrom, transferAmount, pinNumber);
                    if(success)
                        System.out.println("Your transfer was successful ");
                    else
                        System.out.println("NOT SUCCESSFUL");
                    break;

               */ case 5 : System.out.println("*****ACCOUNT DETAILS********");
                    System.out.println("Enter your account number");
                    int accNo = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo1 = sc.nextInt();
                    Account myAccount = bankServices.loginAccount(accNo , pinNo1);
                    if(myAccount == null){
                        System.out.println("******Invalid account number or pin******");
                    }else{
                        System.out.println("Welcome to your account : " + myAccount.getAccountHolderName());
                        System.out.println("Current balance : " + myAccount.getCurrentBalance());
                    }
                    break;
                case 6 : System.out.println("******ALL ACCOUNTS*******");
                   for(Map.Entry<Integer,Account> accountEntry : bankServices.getAllAccounts().entrySet()){
                       System.out.println("Account number : " + accountEntry.getValue().getAccountNumber());
                       System.out.println("Account holder name : " + accountEntry.getValue().getAccountHolderName());
                       System.out.println("Account balance : " + accountEntry.getValue().getCurrentBalance());
                       System.out.println("****************************************************************");
                   }
                    break;

                case 7 : flag = false;
                    break;

                default: System.out.println("Invalid option");
                    break;
            }
        }
    }
}
