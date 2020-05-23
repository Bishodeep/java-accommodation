/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bishodeep
 */
public class DatabaseConfiguration {

    public static Connection SetDatabaseConfig() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";

        String dbName = "studentportal";
        String dbUsername = "root";
        String dbPassword = "Admin@123";
        Class.forName(dbDriver);
        Connection connection = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return connection;
    }
}
