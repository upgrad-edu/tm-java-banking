package com.upGrad.utils;

class LoanCalculator {
    public static int getFinalAmount(int rate, int time, int principal){
        int interest = rate * time * principal;
        return principal + interest;
    }

    public static double calculateLateFine(int rate, int time, int principal){
        int total = getFinalAmount(rate,time,principal);
        return 0.1 * total;
    }

    public static double calculateEarlyClosingFees(int rate, int time, int principal, int amountPaid){
        int total = getFinalAmount(rate,time,principal);
        int remainAmount = total - amountPaid;
        double lateFine = calculateLateFine(rate,time,principal);
        return remainAmount + lateFine;
    }
}
