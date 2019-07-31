package com.company.jdbc.config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_bank";

    static final String USER = "root";
    static final String PASS = "3sk10000*";

    private static Connection conn = null;

    public  Connection koneksiDB() throws SQLException, ClassNotFoundException {
        if (conn == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                return conn;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"gagal koneksi");
            }
        }
        return conn;
    }

}
