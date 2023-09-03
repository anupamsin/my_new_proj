package com.cybage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    static final String DATABASE_URL="jdbc:mysql://localhost:3306/jpql_db?autoReconnect=true&useSSL=false";
    static final String USER="root";
    static final String PASSWORD="root";
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
   }
}
