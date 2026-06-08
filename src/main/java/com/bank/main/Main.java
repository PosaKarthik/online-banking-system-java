package com.bank.main;


import com.bank.exception.InsufficientBalanceException;
import com.bank.exception.InvalidAccountException;
import com.bank.service.BankingService;
import com.bank.util.DBConnection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        BankingService bankingService=new BankingService();

        while(true){

            System.out.println("================================================");
            System.out.println("                         ONLINE BANKING SYSTEM");
            System.out.println("================================================");

            System.out.println();

            System.out.println("1. Create Account");
            System.out.println("2. Deposite");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");


            System.out.println();

            System.out.println("Enter Choice : ");
            int choice=scanner.nextInt();

            try {

                switch (choice) {

                    case 1:
                        bankingService.createAccount();
                        break;

                    case 2:
                        bankingService.deposite();
                        break;

                    case 3:
                        bankingService.withdraw();
                        break;

                    case 4:
                        bankingService.checkBalance();
                        break;

                    case 5:
                        bankingService.transactionHistory();
                        break;

                    case 6:
                        System.out.println("Thank you for using online banking system");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");

                }
            }
            catch (InvalidAccountException e){
                System.out.println(e.getMessage());
            }
            catch (InsufficientBalanceException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
               System.out.println("Something went wrong : "+e.getMessage());
            }
        }

    }
}