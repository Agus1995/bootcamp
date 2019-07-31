package com.company.jdbc.dao;

import com.company.jdbc.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountData {
    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement statement = null;
    private static Account acc = new Account();
    public AccountData(Connection connection){
        connect = connection;
    }

    public void addAccount(Account account){
        String query = "INSERT INTO tb_account (account_number, account_name, balance, customer_number) " +
                " VALUES (?,?,?,?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1,account.getAccount_number());
            statement.setString(2,account.getAccount_name());
            statement.setDouble(3,account.getBalance());
            statement.setString(4,account.getCustomer_number());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Account getById(String id){
        try {
            String query = "SELECT * FROM tb_account WHERE account_number=?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();

            while (resultSet.next()){
                acc.setAccount_number(resultSet.getString("account_number"));
                acc.setAccount_name(resultSet.getString("account_name"));
                acc.setOpen_date(resultSet.getTimestamp("open_date"));
                acc.setBalance(resultSet.getDouble("balance"));
                acc.setCustomer_number(resultSet.getString("customer_number"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return acc;
    }

    public List<Account> getByCusNumb(String code){
        List<Account> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM tb_account WHERE customer_number=?";
            statement = connect.prepareStatement(query);
            statement.setString(1,code);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Account accnew = new Account();
                accnew.setAccount_number(resultSet.getString("account_number"));
                accnew.setAccount_name(resultSet.getString("account_name"));
                accnew.setBalance(resultSet.getDouble("balance"));
                list.add(accnew);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return list;
    }


    public void topUp(String accNumb, double newBalance){
        try {
            String query = "update tb_account set balance  = ? where account_number =?";
            statement = connect.prepareStatement(query);
            statement.setDouble(1,newBalance);
            statement.setString(2,accNumb);
            statement.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
