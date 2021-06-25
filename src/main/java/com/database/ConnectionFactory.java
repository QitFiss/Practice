package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();
    private ConnectionFactory(){
    }
    public Connection createConnection()
    {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "root");
            System.out.println("Connection to Store DB succesfull!");
        }
        catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        return connection;
    }
    public static Connection  getConnection(){
        return instance.createConnection();
    }
    ;}
