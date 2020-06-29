package com.upGrad.utils;

public class EMICalculator {
    public static int calculateEMIAmount(int totalAmount, int months){
        //we will add emi calculation functionality here
        int emiAmount = 0;
        try{
            emiAmount = totalAmount/months;
        }catch (ArithmeticException ae){
            System.out.println("Number of months can't be less than 1");
        }
        return 0;
    }

    public static int calculateNumberOfEMIs(int totalAmount, int emiAmount){
        //we will add emi calculation functionality here
        return 0;
    }
}
