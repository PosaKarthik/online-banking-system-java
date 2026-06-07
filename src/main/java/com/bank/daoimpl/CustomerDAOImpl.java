package com.bank.daoimpl;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;
import com.bank.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDAOImpl implements CustomerDAO {



    @Override
    public int createCustomer(Customer customer) {

        String query="INSERT INTO Customers(customerName,customerEmail,customerPhone,customerAddress) Values(?,?,?,?) ";


        try(Connection connection= DBConnection.getDbConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerEmail());
            preparedStatement.setString(3, customer.getCustomerPhone());
            preparedStatement.setString(4, customer.getCustomerAddress());


            int rows=preparedStatement.executeUpdate();

            if(rows>0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int customerId = resultSet.getInt(1);
                    System.out.println("Customer created successfully");

                    return customerId;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
