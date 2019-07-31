package com.company.jdbc.service;

import com.company.jdbc.Error.ErrorHandling;
import com.company.jdbc.config.DBConnection;
import com.company.jdbc.dao.AccountData;
import com.company.jdbc.dao.CustomerData;
import com.company.jdbc.entity.Account;
import com.company.jdbc.entity.Customer;
import com.company.jdbc.entity.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements IAccount {
    private AccountData accountData;
    private static Account account = new Account();
    private static Transaction tr = new Transaction();
    DBConnection dbConnection = new DBConnection();
    ICustomer customer = new CustomerImpl();
    IWallet wallet = new WalletImpl();
    ITransaction transaction = new TransactionImpl();
    ErrorHandling errorHandling = new ErrorHandling();

    public AccountImpl(){
        try {
            accountData = new AccountData(dbConnection.koneksiDB());
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(Account account) {
        String id = account.getCustomer_number();
        Customer cus = new Customer();
        cus = customer.getById(id);
        if (cus.getCustomer_number() == null){
            errorHandling.notFoundId(account.getCustomer_number());
        }else {
            try {
                accountData.addAccount(account);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public Account getById(String id) {
        account = accountData.getById(id);
        return account;
    }

    @Override
    public List<Account> getByCode(String code) {
        List<Account> listAccount = new ArrayList<>();
        try {
            listAccount =  accountData.getByCusNumb(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listAccount;
    }



    /*@Override
    public void topUp(int id, String accNumb, double newBalance, String code) {
        Transaction tr = new Transaction();
        if (wallet.getAccountWallet(id,accNumb)) {
            try {
                account = accountData.getById(accNumb);
                double balance = account.getBalance();
                double newBalance1 = newBalance + balance;
                accountData.topUp(accNumb, newBalance1);

                tr.setAccountNumberDebit(accNumb);
                tr.setAmount(newBalance);
                tr.setTransactionType(code);

                transaction.addDebitTransaction(tr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("ID OR account number not found");
        }
    }*/

    @Override
    public void updateTfplus(String accNumb, double newBalance, String code) {
      //  Transaction tr = new Transaction();
        try{
            account = accountData.getById(accNumb);
            double balance = account.getBalance();
            double newBalance1 = newBalance + balance;
            accountData.topUp(accNumb, newBalance1);

            tr.setAccountNumberDebit(accNumb);
            tr.setAmount(newBalance);
            tr.setTransactionType(code);

            transaction.addDebitTransaction(tr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateTfmin(String accNumb, double newBalance, String code) {
   //     Transaction tr = new Transaction();
        try{
            account = accountData.getById(accNumb);
            double balance = account.getBalance();
            double newBalance1 = balance - newBalance;
            accountData.topUp(accNumb, newBalance1);

            tr.setAccountNumberDebit(accNumb);
            tr.setAmount(newBalance);
            tr.setTransactionType(code);
            transaction.addCreditTransaction(tr);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
