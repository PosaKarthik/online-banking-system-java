package com.bank.dao;

import com.bank.model.Account;

public interface AccountDAO {

    int createAccount(Account account);

    void deposite(int accountNumber,double amount);
}
