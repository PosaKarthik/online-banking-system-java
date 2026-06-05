create database banking_system;

       use banking_system;


create table customers(
                          customerId INT PRIMARY KEY AUTO_INCREMENT,
                          customerName VARCHAR(100) NOT NULL,
                          customerEmail VARCHAR(100) UNIQUE,
                          customerPhone VARCHAR(15),
                          customerAddress VARCHAR(200)
);

create  table accounts(
                          accountNumber INT PRIMARY KEY AUTO_INCREMENT,
                          customerId INT,
                          accountType VARCHAR(50) NOT NULL,
                          accountBalance DOUBLE,
                          FOREIGN KEY(customerId) REFERENCES customers(customerId)
)AUTO_INCREMENT=1001;

create table Transactions(
                             transactionId INT PRIMARY KEY AUTO_INCREMENT,
                             accountNumber INT,
                             transactionType VARCHAR(50) NOT NULL,
                             transactionAmount DOUBLE,
                             FOREIGN KEY(accountNumber) REFERENCES accounts(accountNumber)
);