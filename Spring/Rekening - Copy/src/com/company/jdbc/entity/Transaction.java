package com.company.jdbc.entity;

import java.sql.Timestamp;

public class Transaction {
    private String accountNumberDebit;
    private String getAccountNumberKredit;
    private double amount;
    private String codeTrans;
    private String description;
    private String TransactionType;
    private Timestamp date;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCodeTrans() {
        return codeTrans;
    }

    public void setCodeTrans(String codeTrans) {
        this.codeTrans = codeTrans;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountNumberDebit() {
        return accountNumberDebit;
    }

    public void setAccountNumberDebit(String accountNumberDebit) {
        this.accountNumberDebit = accountNumberDebit;
    }

    public String getGetAccountNumberKredit() {
        return getAccountNumberKredit;
    }

    public void setGetAccountNumberKredit(String getAccountNumberKredit) {
        this.getAccountNumberKredit = getAccountNumberKredit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }
}
