package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name,balance,0);
        this.institutionName = institutionName;

    }

    public String getName()
    {
        return super.getName();
    }

    public double getBalance()
    {
        return super.getBalance();
    }

    public void setBalance(double balance)
    {
        super.setBalance(balance);
    }

    public double getMinBalance()
    {
        return super.getMinBalance();
    }

}
