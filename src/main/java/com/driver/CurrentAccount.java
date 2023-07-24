package com.driver;

import java.util.Random;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId()
    {
        return this.tradeLicenseId;
    }

    public String getName() {
        return super.getName();
    }

    public double getBalance() {
        return super.getBalance();
    }

    public void setBalance(double balance)
    {
        super.setBalance(balance);
    }

    public double getMinBalance() {
        return super.getMinBalance();
    }

    public boolean isConsecutive(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                return true;
        }
        return false;
    }

    public void shuffle(char[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] arr = tradeLicenseId.toCharArray();

        int[] freq = new int[26];


        if (isConsecutive(arr)) {
            for (int i = 0; i < arr.length; i++) {
                char ch = arr[i];
                freq[ch - 'A']++;
            }


            for (int i = 0; i < 26; i++) {
                if (freq[i] >= tradeLicenseId.length() - 1)
                    throw new InvalidLicenseException("Valid License can not be generated");
            }

            while (isConsecutive(arr)) {
                shuffle(arr);
            }

            tradeLicenseId = String.valueOf(arr);
        }

    }
}
