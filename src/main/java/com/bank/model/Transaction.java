package com.bank.model;

public class Transaction {


    private  int transactionId;
    private int accountNumber;
    private String transactionType;
    private double transactionAmount;


    public Transaction(int accountNumber,String transactionType,double transactionAmount) {

        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;

    }

    public Transaction(){

    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber=" + accountNumber +
                ", transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
