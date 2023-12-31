package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

//    public void setMinBalance(double minBalance) {
//        this.minBalance = minBalance;
//    }

    public int digitSum(String n)
    {
        int sum = 0;
        for(int i=0; i<n.length(); i++)
        {
            char ch = n.charAt(i);
            sum+= (ch-'0');
        }
        return sum;
    }


    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");

        } else {

            String accNum = "";
            int sum_of_digits = 0;

            while (sum_of_digits != sum) {
                accNum = "";
                accNum += Math.round(Math.random() * Math.pow(10, digits));
                sum_of_digits = digitSum(accNum);
            }

            return accNum;
        }
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance - amount < minBalance)
        {
            throw new Exception("Insufficient Balance");
        }
        else
        {
            balance-=amount;
        }
    }

}