package com.bank.model;

public class Account {


    private int accountId;
    private int customerId;
    private String accountType;
    private double accountBalance;


    public Account( int customerId, String accountType,double accountBalance) {

        this.customerId = customerId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;

    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalanece(double accountBalanece) {
        this.accountBalance = accountBalanece;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountBalanece=" + accountBalance +
                ", accountId=" + accountId +
                ", customerId=" + customerId +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
