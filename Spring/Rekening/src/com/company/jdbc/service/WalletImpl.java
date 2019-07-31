package com.company.jdbc.service;

import com.company.jdbc.Error.ErrorHandling;
import com.company.jdbc.config.DBConnection;
import com.company.jdbc.dao.WalletData;
import com.company.jdbc.entity.Account;
import com.company.jdbc.entity.Wallet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletImpl implements IWallet{
    private WalletData walletData;
    private static Wallet wal = new Wallet();
    private static IWallet walt = new WalletImpl();
    private static IAccount account = new AccountImpl();
    private static ErrorHandling errorHandling = new ErrorHandling();
    DBConnection dbConnection = new DBConnection();

    public WalletImpl(){
        try {
            walletData = new WalletData(dbConnection.koneksiDB());
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    @Override
    public void addWallet(Wallet wallet) {
        try {
            walletData.addWallet(wallet);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Wallet searchLast() {
        return null;
    }

    @Override
    public Wallet getById(int id) {
    //    Wallet wal = new Wallet();
        wal = walletData.getById(id);
        return wal;
    }

    @Override
    public List<Wallet> getByCode(String code) {
        List<Wallet> walList = new ArrayList<>();
        try {
            walList =  walletData.getByCusNumb(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return walList;
    }

    @Override
    public List<Wallet> getWalleteReg(String code) {
        List<Wallet> wallets = new ArrayList<>();

        try {
            wallets = walletData.getWalleteReg(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return wallets;
    }

    @Override
    public boolean getAccountWallet(int id, String accName) {
     //   Wallet wal = new Wallet();
        try {
            wal = walletData.getAccountWallet(id,accName);
        }catch (Exception e){
            e.printStackTrace();
        }
        int idWal = wal.getId();
        String accNumb = wal.getAccount_number();
        if (idWal == 0 || accNumb == null ){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void registerWallet(int id, String accNumb) {
     //   Wallet wal = new Wallet();
        wal = walletData.getById(id);
        String des = wal.getDescription();
        Account ac = new Account();
        ac = account.getById(accNumb);
        String acn = ac.getAccount_number();

        if (des!=null && acn!=null){
            walletData.registerWallet(id,accNumb);
        }else {
            System.out.println("ID yang dimasukkan tida terdaftar");
        }
    }

    @Override
    public void unReg(int id, String accNumb) {
        try {
            walletData.unReg(id,accNumb);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id, String code) {
        try {
            wal = walletData.getByWallet(id);
            if (wal.getAccount_number()==null){
                walletData.deleteWallet(id, code);
            }else {
                System.out.println("You must unregister your wallet");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
