package com.bank.dao;

import com.bank.model.Transaction;

import java.util.List;

public interface TransactionDAO {


    void addTransaction(Transaction transaction);

    List<Transaction> getTransactions(int accountNumber);


}
