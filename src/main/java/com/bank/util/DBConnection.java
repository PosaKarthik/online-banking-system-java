package com.bank.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {


    public static Connection getDbConnection() {

        Connection connection=null;

        try {
            FileInputStream fileInputStream = new FileInputStream("db.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password")
            );

            System.out.println("Database connected successfully");

        } catch (SQLException e) {
           e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
