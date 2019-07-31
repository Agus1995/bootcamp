package com.company.jdbc;

import java.sql.*;

public class Koneksi  {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_enigma";

    static final String USER = "root";
    static final String PASS = "3sk10000*";

    public  Connection connectDB() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        return conn;
    }
}
