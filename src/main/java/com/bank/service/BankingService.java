package com.bank.service;


import com.bank.daoimpl.AccountDAOImpl;
import com.bank.daoimpl.CustomerDAOImpl;
import com.bank.model.Account;
import com.bank.model.Customer;

import java.util.Scanner;

public class BankingService {

    private CustomerDAOImpl customerDAO=new CustomerDAOImpl();
    private AccountDAOImpl accountDAO=new AccountDAOImpl();

    public void createAccount(){

        Scanner scanner=new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("                            CREATE ACCOUNT");
        System.out.println("=================================================");
        System.out.println();

        System.out.println("Enter Name : ");
        String name=scanner.nextLine();

        System.out.println("Enter Email : ");
        String email=scanner.nextLine();

        System.out.println("Enter Phone : ");
        String phone=scanner.nextLine();

        System.out.println("Enter Address : ");
        String address=scanner.nextLine();

        Customer customer=new Customer(name,email,phone,address);

        int customerId=customerDAO.createCustomer(customer);

        System.out.println("Enter AccountType : (Savings/Current)");
        String accountType=scanner.nextLine();

        Account account=new Account(customerId,accountType,0.0);

        int accountNumber=accountDAO.createAccount(account);

        System.out.println("=================================================");

        System.out.println("Customer ID : "+customerId);
        System.out.println("Account Number : "+accountNumber);

        System.out.println("=================================================");



    }

public void deposite(){

        Scanner scanner=new Scanner(System.in);

    System.out.println("=================================================");
    System.out.println("                              DEPOSITE");
    System.out.println("=================================================");

    System.out.println("Enter Account Number : ");
    int accountNumber=scanner.nextInt();

    System.out.println("Enter Amount : ");
    double amount=scanner.nextDouble();

    accountDAO.deposite(accountNumber,amount);


}


public void checkBalance(){

        Scanner scanner=new Scanner(System.in);

    System.out.println("=================================================");
    System.out.println("                              CHECK BALANCE");
    System.out.println("=================================================");
    System.out.println();

        System.out.println("Enter Account Number : ");
        int accountNumber=scanner.nextInt();

        double accountBalance= accountDAO.getBalance(accountNumber);

        System.out.println();
        System.out.println("Current Balance : "+accountBalance);

}

}
