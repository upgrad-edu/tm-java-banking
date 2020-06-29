package com.upGrad.utils;

public class EMICalculator {
    public static int calculateEMIAmount(int totalAmount, int months) {
        //we will add emi calculation functionality here
        int emiAmount = 0;
        try {
            emiAmount = totalAmount / months;
        } catch (ArithmeticException ae) {
            System.out.println("Number of months can't be less than 1");
        } catch (Exception e) {
            System.out.println("Exception has been caught");
        } finally {
            System.out.println("Thanks for using our service");
        }
        return emiAmount;
    }

    public static int calculateNumberOfEMIs(int totalAmount, int emiAmount) {
        //we will add emi calculation functionality here
        int emiPayments = 0;
        try {
            emiPayments = totalAmount / emiAmount;
        } catch (ArithmeticException ae) {
            System.out.println("Thanks for using our service");
        } catch (Exception e) {
            System.out.println("Exception has been caught");
        } finally {
            System.out.println("Thanks for using our service");
        }
        return emiPayments;
    }
}
