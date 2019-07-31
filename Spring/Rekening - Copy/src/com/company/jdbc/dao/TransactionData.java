package com.company.jdbc.dao;

import com.company.jdbc.entity.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionData {
    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement statement = null;
    private static Transaction transaction = new Transaction();

    public TransactionData(Connection connection){
        connect = connection;
    }

    public Transaction getById(String id){
        try {
            String query = "SELECT * FROM tb_transaction_type WHERE code=?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();

            while (resultSet.next()){
                transaction.setCodeTrans(resultSet.getString("code"));
                transaction.setDescription(resultSet.getString("description"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return transaction;
    }

    public void addDebet(Transaction transaction){
        String query = "INSERT INTO tb_transaction (account_number_debit, amount, transaction_type) " + " VALUES (?,?,?)";
        try{
            statement = connect.prepareStatement(query);
            statement.setString(1,transaction.getAccountNumberDebit());
            statement.setDouble(2,transaction.getAmount());
            statement.setString(3,transaction.getTransactionType());
            statement.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
        }
    }
    public void addCredit(Transaction transaction){
        String query = "INSERT INTO tb_transaction (account_number_kredit, amount, transaction_type) VALUES (?,?,?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1,transaction.getAccountNumberDebit());
            statement.setDouble(2,transaction.getAmount());
            statement.setString(3,transaction.getTransactionType());
            statement.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public List<Transaction> getTransaction(String code){
        List<Transaction> list = new ArrayList<>();
        //SELECT tabel1.*, tabel2.* FROM tabel1, tabel2
        //WHERE tabel1.PK=tabel2.FK;
        try {
            String sql =
                    "SELECT tb_transaction.*, tb_transaction_type.* FROM tb_transaction, tb_transaction_type "+
                    "WHERE tb_transaction.account_number_debit = ? OR tb_transaction.account_number_kredit=? " +
                    "AND tb_transaction.transaction_type = tb_transaction_type.code";
         //   String query = "SELECT * FROM tb_transaction WHERE account_number_debit = ? OR account_number_kredit= ? ";
            statement = connect.prepareStatement(sql);
            statement.setString(1,code);
            statement.setString(2,code);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                transaction.setTransactionType(resultSet.getString("description"));
                transaction.setDate(resultSet.getTimestamp("date"));
                transaction.setAmount(resultSet.getDouble("amount"));
                list.add(transaction);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return list;
    }





}
