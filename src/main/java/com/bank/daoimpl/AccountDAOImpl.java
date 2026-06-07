package com.bank.daoimpl;

import com.bank.dao.AccountDAO;
import com.bank.model.Account;
import com.bank.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public int createAccount(Account account) {

        String query="INSERT INTO Accounts(customerId,accountType,accountBalance) VALUES(?,?,?)";

        try(Connection connection= DBConnection.getDbConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setInt(1,account.getCustomerId());
            preparedStatement.setString(2,account.getAccountType());
            preparedStatement.setDouble(3,account.getAccountBalance());


            int rows=preparedStatement.executeUpdate();

            if(rows>0){
                ResultSet resultSet=preparedStatement.getGeneratedKeys();

                if(resultSet.next()){
                    int accountNumber=resultSet.getInt(1);

                    System.out.println("Account created successfully");
                    return accountNumber;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deposite(int accountNumber, double amount) {

        String query="UPDATE Accounts SET accountBalance=accountBalance+? WHERE accountNumber=?";

        try(
                Connection connection=DBConnection.getDbConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(query);
                ){

            preparedStatement.setDouble(1,amount);
            preparedStatement.setInt(2,accountNumber);

            int rows=preparedStatement.executeUpdate();

            if(rows>0){
                System.out.println("Amount Deposite Successfull");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    public double getBalance(int accountNumber) {

        String query="SELECT accountBalance FROM Accounts WHERE accountNumber=?";

        try(
                Connection connection=DBConnection.getDbConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(query)
                ){

            preparedStatement.setInt(1,accountNumber);

            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                return resultSet.getDouble("accountBalance");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void withdraw(int accountNumber, double amount) {

        String query="UPDATE Accounts SET accountBalance=accountBalance-? WHERE accountNumber=?";

        try(
                Connection connection=DBConnection.getDbConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(query)
                ){

            preparedStatement.setDouble(1,amount);
            preparedStatement.setInt(2,accountNumber);

            int rows = preparedStatement.executeUpdate();

            if(rows>0){
                System.out.println("Withdraw Successfull");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    public boolean accountExists(int accountNumber) {

        String query="SELECT * FROM Accounts WHERE accountNumber=?";

        try(
                Connection connection=DBConnection.getDbConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(query);
                ){

                preparedStatement.setInt(1,accountNumber);

                ResultSet resultSet=preparedStatement.executeQuery();

                return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
