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
}
