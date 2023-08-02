package com.driver;

import java.util.HashMap;
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


    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] arr = tradeLicenseId.toCharArray();
        int n = arr.length;

        int maxFreq = 0;
        char maxCh = ' ';

        if (isConsecutive(arr)) {
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i = 0; i<n; i++)
            {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }

            for(char ch : map.keySet())
            {
                if(map.get(ch) > maxFreq)
                {
                    maxFreq = map.get(ch);
                    maxCh = ch;
                }
            }

            if(maxFreq > Math.ceil((double)n/2))
                throw new Exception("Valid License can not be generated");

            int k=0;

            for(int i=0; i<maxFreq; i++)
            {
                if(k >= n)
                    k=1;
                arr[k] = maxCh;
                k+=2;
            }

            for(int i=0; i<n; i++)
            {
                char c = tradeLicenseId.charAt(i);
                if(c!=maxCh)
                {
                    if(k>=n)
                        k=1;
                    arr[k] = c;
                    k+=2;
                }
            }

            tradeLicenseId = String.valueOf(arr);
        }

    }
}
