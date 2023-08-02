package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
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
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > maxWithdrawalLimit)
            throw new Exception("Maximum Withdraw Limit Exceed");
        else if (amount > getBalance())
            throw new Exception("Insufficient Balance");
        else
        {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest = 0;
        double principal = getBalance();
        interest = (principal * rate * years)/100;
        double newAmount = principal + interest;
        return newAmount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        double principal = getBalance();
        double newAmount = principal * Math.pow((1 + rate/(100*times)),times*years);
        return newAmount;
    }

}
