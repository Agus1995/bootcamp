package com.company.jdbc.service;

import com.company.jdbc.config.DBConnection;
import com.company.jdbc.dao.TransactionData;
import com.company.jdbc.entity.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionImpl implements ITransaction {
    private TransactionData transactionData;
    private static Transaction transaction = new Transaction();


    DBConnection dbConnection = new DBConnection();

    public TransactionImpl(){
        try {
            transactionData = new TransactionData(dbConnection.koneksiDB());
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean getCode(String code) {
        transaction = transactionData.getById(code);
        if (transaction.getCodeTrans()==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void addDebitTransaction(Transaction transaction) {
        try{
            transactionData.addDebet(transaction);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addCreditTransaction(Transaction transaction) {
        try {
            transactionData.addCredit(transaction);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Transaction> getTransaction(String code) {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList = transactionData.getTransaction(code);
        return transactionList;
    }
}
