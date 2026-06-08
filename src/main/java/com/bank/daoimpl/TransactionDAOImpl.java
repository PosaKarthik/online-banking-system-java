package com.bank.daoimpl;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;
import com.bank.util.DBConnection;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public void addTransaction(Transaction transaction) {

        String query="INSERT INTO Accounts(accountNumber,transactionType,transactionAmount) VALUES(?,?,?)";


        try(
                Connection connection= DBConnection.getDbConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(query)
                ){

                preparedStatement.setInt(1,transaction.getAccountNumber());
                preparedStatement.setString(2,transaction.getTransactionType());
                preparedStatement.setDouble(3,transaction.getTransactionAmount());

                int rows=preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Transaction> getTransactions(int accountNumber) {

        List<Transaction> transactions=new ArrayList<>();

        String query="SELECT * FROM Accounts WHERE accountNumber=?";

        try(
                Connection connection=DBConnection.getDbConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(query)
                ){


            preparedStatement.setInt(1,accountNumber);

            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){

                Transaction transaction=new Transaction();

                transaction.setTransactionId(resultSet.getInt("transactionId"));
                transaction.setAccountNumber(resultSet.getInt("accountNumber"));
                transaction.setTransactionType(resultSet.getString("transactionType"));
                transaction.setTransactionAmount(resultSet.getDouble("transactionAmount"));

                transactions.add(transaction);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
