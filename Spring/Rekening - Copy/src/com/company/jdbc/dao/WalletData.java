package com.company.jdbc.dao;

import com.company.jdbc.entity.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletData {
    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement statement = null;
    private static Wallet wal = new Wallet();
    public WalletData(Connection connection){
        connect = connection;
    }

    public void addWallet(Wallet wallet){
        String query = "INSERT INTO tb_walet (description, customer_number) VALUES (?,?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1,wallet.getDescription());
            statement.setString(2,wallet.getCustomer_number());
            statement.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
    public void registerWallet(int id,  String accNumb){
        String query = "INSERT INTO tb_wallet_account (wallet_id, account_number) VALUES(?,?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,accNumb);
            statement.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public Wallet searchLast(){
        Wallet wallet = new Wallet();
        try {
            String query = "SELECT * FROM tb_wallet ORDER BY id DESC LIMIT 1";
            PreparedStatement stmt = connect.prepareStatement(query);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                wallet.setId(resultSet.getInt("id"));
                wallet.setDescription(resultSet.getString("description"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return wallet;
    }

    public Wallet getById(int id){
        try {
            String query = "SELECT * FROM tb_walet WHERE id=?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, String.valueOf(id));
            resultSet = stmt.executeQuery();

            while (resultSet.next()){
                wal.setId(resultSet.getInt("id"));
                wal.setDescription(resultSet.getString("description"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return wal;
    }

    public List<Wallet> getByCusNumb(String code){
        List<Wallet> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM tb_walet WHERE customer_number=?";
            statement = connect.prepareStatement(query);
            statement.setString(1,code);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Wallet walnew = new Wallet();
                walnew.setId(resultSet.getInt("id"));
                walnew.setDescription(resultSet.getString("description"));
                walnew.setCustomer_number(resultSet.getString("customer_number"));
                list.add(walnew);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return list;
    }
    public Wallet getAccountWallet(int id, String accName){
        try {
            String query = "   SELECT * FROM tb_wallet_account WHERE wallet_id=? AND account_number=?";
            statement = connect.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,accName);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                wal.setId(resultSet.getInt("wallet_id"));
                wal.setAccount_number(resultSet.getString("account_number"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return wal;
    }
    public void unReg(int id, String accNumb){
        try {

            String query = "DELETE FROM tb_wallet_account WHERE wallet_id=? AND account_number=?";
            statement = connect.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,accNumb);
            statement.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
