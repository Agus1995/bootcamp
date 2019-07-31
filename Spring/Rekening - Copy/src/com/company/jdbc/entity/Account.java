package com.company.jdbc.entity;

import java.sql.Timestamp;

public class Account {
    private String account_number;
    private String account_name;
    private double balance;
    private Timestamp open_date;
    private String customer_number;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Timestamp getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Timestamp open_date) {
        this.open_date = open_date;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }
}
